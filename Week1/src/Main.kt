import bankAccount.BankAccountClass
import employeeManagmentSystem.Employee
import employeeManagmentSystem.Manager
import shoppingCart.Product
import shoppingCart.ShoppingCart

fun main() {

    // Bank Account
    val bankAccount = BankAccountClass(accountNumber = "1", balance = 2.3, customerName = "Demis Lavrentidis")
    bankAccount.deposit(10.0)
    bankAccount.displayBalance()
    bankAccount.withdraw(5.0)
    bankAccount.displayBalance()
    bankAccount.withdraw(8.0)

    // Employee management
    val employee = Employee(name = "Terry Hobbs", id = 0, salary = 2500.0)
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

    // Shopping Cart
    val productOne = Product(name = "Rice", price = 6.0, category = "Grains")
    val productTwo = Product(name = "Spaghetti", price = 8.0, category = "Pasta")
    val productThree = Product(name = "Onion", price = 9.0, category = "Vegetables")
    val shoppingCart = ShoppingCart().apply {
        addProduct(productOne)
        addProduct(productTwo)
        addProduct(productThree)
    }

    shoppingCart.calculateTotal().apply { println(this) }
}