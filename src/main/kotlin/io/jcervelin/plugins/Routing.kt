package io.jcervelin.plugins

import io.jcervelin.usecases.handleAnswer
import io.jcervelin.usecases.randomQuestion
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/next-question") {
            call.respondText(randomQuestion())
        }
        get("/submit-answer") {
            val question = call.queryParameters["question"]
            val answer = call.queryParameters["answer"]

            call.respondText(handleAnswer(question!!, answer!!))
        }
    }
}
