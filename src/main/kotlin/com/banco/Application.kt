package com.banco

import com.banco.plugins.configureHTTP
import com.banco.plugins.configureRouting
import com.banco.plugins.configureSecurity
import com.banco.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.InputStream

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureHTTP()
        configureSerialization()
        configureSecurity()
        configureRouting()

    }.start(wait = true)
}




