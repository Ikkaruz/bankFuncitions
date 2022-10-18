package com.example.models


import com.banco.models.Investment
import com.fasterxml.jackson.module.kotlin.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import java.io.File
import java.io.FileWriter

var mapper = jacksonObjectMapper()
var users = File("src\\main\\kotlin\\com\\banco\\assets\\users.json").readText()

class Usuario {

    constructor(){
    }

    constructor(nick: String, password: String, money: Int, role: String){
        this.nick = nick
        this.password = password
        this.money = money
        this.role = role
    }

    @Expose
    var nick: String? = null

    @Expose
    var password: String? = null

    @Expose
    var money: Int? = null

    @Expose
    var role: String? = null
}

fun checkLogin(nick: String?, password: String?): String? {

    var usuarios = mapper.readValue(users, List::class.java)

    usuarios.forEach {
        var usuario: Usuario = mapper.convertValue(it, Usuario::class.java)
        if (usuario.nick == nick && usuario.password == password) {
            return mapper.writeValueAsString(usuario)
        }
    }
    return ""
}

fun addUser(nick: String, password: String, money: Int, role: String): String {
    var usuario: Usuario
    var usuarios = mapper.readValue(users, List::class.java)
    var usuariosObjetos = arrayListOf<Usuario>()

    usuarios.forEach {
        usuario = mapper.convertValue(it, Usuario::class.java)
        if (usuario.nick == nick) {
            return "Usuario Ya Está Registrado"
        } else {
            usuariosObjetos.add(usuario)
        }
    }

    usuario = Usuario(nick, password, money, role)
    usuariosObjetos.add(usuario)

    FileWriter("src\\main\\kotlin\\com\\banco\\assets\\users.json").use { it.write(mapper.writeValueAsString(usuariosObjetos)) }

    return "Done!"

}