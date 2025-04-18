package employeeManagmentSystem

open class Employee(val name: String, val id: Int, val salary: Double) {
    init {
        require(id >= 0) {
            println("id cannot be less than 0")
        }
    }

    open fun calculateBonus() = salary * 0.1

    companion object {
        private var nextId = 1
        fun generateUniqueId(): Int {
            return nextId++
        }

    }
}

class Manager(salary: Double, name: String) : Employee(salary = salary, name = name, id = generateUniqueId()) {
    override fun calculateBonus(): Double = salary * 0.2
}

class Developer(salary: Double, name: String) : Employee(salary = salary, name = name, id = generateUniqueId()) {
    override fun calculateBonus(): Double = salary * 0.15
}

fun main() {
    // Employee management
    val employee = Employee(name = "Terry Hobbs", id = -1, salary = 2500.0)
    println(employee.calculateBonus())
    println(employee.id)

    val manager = Manager(name = "Demis Lavrentidis", salary = 2500.0)
    println(manager.calculateBonus())
    println(manager.id)

    val managerTwo = Manager(name = "Rey Rey", salary = 3000.0)
    println(managerTwo.calculateBonus())
    println(managerTwo.id)

    // Bonus task
    val employees = listOf(employee, manager, managerTwo)
    employees.forEach {
        println("Employee name: ${it.name}, Employee id: ${it.id}, Employee bonus: ${it.calculateBonus()}")
    }
}