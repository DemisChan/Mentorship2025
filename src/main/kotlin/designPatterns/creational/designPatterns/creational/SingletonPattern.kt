package org.mentorship2025.designPatterns.creational.designPatterns.creational


// Implement the Logger as a singleton object.
// It should have a private list to store log messages.
// It needs a log() method to add messages to the list.
// It needs a printLogs() method to print all stored messages.
object Logger {
    private val logs = mutableListOf<String>()

    fun log(message: String) {
        logs.add(message)
    }

    fun printLogs() {
        println("--- Logger Start ---")
        logs.forEach(::println)
        println("--- Logger End ---")
    }
}

fun main() {
    println("Starting application.")

    // Log from the main function
    Logger.log("Main function started.")

    // Simulate logging from another part of the app
    ServiceA().doSomething()
    ServiceB().doSomethingElse()

    Logger.log("Application finished.")

    // Print all logs from the single logger instance
    Logger.printLogs()
}

class ServiceA {
    fun doSomething() {
        Logger.log("ServiceA is doing something.")
    }
}

class ServiceB {
    fun doSomethingElse() {
        Logger.log("ServiceB is doing something else.")
    }
}