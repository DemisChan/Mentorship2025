fun main() {
    val bankAccount = BankAccountClass(accountNumber = "1", balance = 2.3, customerName = "Demis Lavrentidis")
    bankAccount.deposit(10.0)
    bankAccount.displayBalance()
    bankAccount.withdraw(5.0)
    bankAccount.displayBalance()
    bankAccount.withdraw(8.0)
}