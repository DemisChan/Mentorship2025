import bankAccount.BankAccountClass
import employeeManagmentSystem.Employee
import employeeManagmentSystem.Manager

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

    val manager2 = Manager(name = "Rey", salary = 3000.0)
    println(manager2.calculateBonus())
    println(manager2.id)
}