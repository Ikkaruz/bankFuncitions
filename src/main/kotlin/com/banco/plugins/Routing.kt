package com.banco.plugins

import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import loginRouting
import investmentsRouting
import userRouting

fun Application.configureRouting() {
    routing {
        loginRouting()
        investmentsRouting()
        userRouting()
    }
}
