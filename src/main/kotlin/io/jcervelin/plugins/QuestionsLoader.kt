package io.jcervelin.plugins

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

val questionsMap = HashMap<String, String>()

fun loadQuestionsFromCSV(fileName: String): HashMap<String, String> {
    val resourceAsStream = {}.javaClass.getResourceAsStream(fileName)!!
    csvReader().open(resourceAsStream) {
        readAllWithHeaderAsSequence().forEach { row ->
            row["question"]?.let { question ->
                row["answer"]?.let { answer ->
                    questionsMap[question] = answer
                }
            }
        }
    }
    return questionsMap.ifEmpty { throw RuntimeException("Questions not loaded correctly") }
}

//fun main() {
//    val questionsMap = loadQuestionsFromCSV("/questions.csv")
//    questionsMap.forEach { (question, answer) ->
//        println("$question -> $answer")
//    }
//}