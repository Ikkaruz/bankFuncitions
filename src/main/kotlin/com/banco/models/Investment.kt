package com.banco.models

import com.example.models.users
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.annotations.Expose
import java.io.File
import java.io.FileWriter

var mapper = jacksonObjectMapper()
var investments = File("src\\main\\kotlin\\com\\banco\\assets\\investments.json").readText()

class Investment {

    constructor(){
    }

    constructor(name: String?, min_value: String?, description: String?, owner: String?, investors: String?){
        this.name = name
        this.min_value = Integer.parseInt(min_value)
        this.description = description
        this.owner = owner
        this.investors = investors
    }

    @Expose
    var name: String? = null

    @Expose
    var min_value: Int? = null

    @Expose
    var description: String? = null

    @Expose
    var owner: String? = null

    @Expose
    var investors: String? = null
}

var strangeListInvestments = com.example.models.mapper.readValue(investments, List::class.java)
var objectListInvestments = arrayListOf<Investment>()

fun generateJSON() {
    strangeListInvestments.forEach {
        var invest: Investment = com.example.models.mapper.convertValue(it, Investment::class.java)
        objectListInvestments.add(invest)
    }
}

fun createInvestment(name: String?, min_value: String?, description: String?, owner: String?, investors: String?): String {

    generateJSON()

    objectListInvestments.forEach {
        if (it.name == name)
            return ""
    }

    var invest = Investment(name, min_value, description, owner, investors)
    objectListInvestments.add(invest)
    print(mapper.writeValueAsString(objectListInvestments))
    FileWriter("src\\main\\kotlin\\com\\banco\\assets\\investments.json").use { it.write(mapper.writeValueAsString(objectListInvestments)) }

    return "Done!"
}

@JvmName("getInvestments1")
fun getInvestments(): String {
    return investments
}