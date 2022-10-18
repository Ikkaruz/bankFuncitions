package com.serialize

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

val employeeJSON = """
    {
       "firstName": "john",
       "lastName": "doe",
       "email": "john@gmail.com"
    }
""".trimIndent()

@Serializable
data class Employee(val firstName: String,
                    val lastName: String,
                    val email: String)

fun main(args: Array<String>){
    //Decode employee from string
    val employeeObject = Json.decodeFromString<Employee>(employeeJSON);
    println(employeeObject);
}