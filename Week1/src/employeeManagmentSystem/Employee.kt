package employeeManagmentSystem

open class Employee(val name: String, val id: Int, val salary: Double) {
    init {
        require(id >= 0)
    }
    open fun calculateBonus() = salary * 0.1

    companion object {
        private var nextId = 1
        fun generateUniqueId(): Int {
            return nextId++
        }

    }
}

class Manager(salary: Double, name: String): Employee(salary = salary, name = name, id = generateUniqueId()) {
    override fun calculateBonus(): Double = salary * 0.2
}