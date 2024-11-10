package io.jcervelin.usecases

import io.jcervelin.plugins.questionsMap
import io.jcervelin.usecases.PossibleAnswer.*

fun randomQuestion() = questionsMap.keys.random()

fun checkAnswer(question: String, answer: String) = questionsMap[question].equals(answer.uppercase())

enum class PossibleAnswer(val formatted: String) {
    CORRECT("Correct!"), INCORRECT("Incorrect!"), INVALID_ANSWER("Invalid answer")
}

fun handleAnswer(question: String?, answer: String?) =
    when {
        question.isNullOrBlank() || answer.isNullOrBlank() -> INVALID_ANSWER.formatted
        checkAnswer(question, answer) -> CORRECT.formatted
        else -> INCORRECT.formatted
    }
