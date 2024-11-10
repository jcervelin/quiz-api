package io.jcervelin

import io.jcervelin.plugins.loadQuestionsFromCSV
import io.jcervelin.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    loadQuestionsFromCSV("/questions.csv")
    configureHTTP()
    configureSerialization()
    configureRouting()
}
