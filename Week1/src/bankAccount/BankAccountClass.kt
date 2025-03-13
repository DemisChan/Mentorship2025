package bankAccount

class BankAccountClass(val accountNumber: String, var balance: Double, val customerName: String) :
    SavingsAccount(interestRate = 0.0) {

    // Bonus task
    override fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            println("Withdrawing $amount from $customerName account.")
            balance -= amount
        } else {
            println("Insufficient funds or invalid withdrawal amount")
        }
    }

    fun deposit(amount: Double) {
        if (amount > 0) {
            println("Depositing $amount to $customerName account.")
            balance += amount
        } else {
            println("Invalid deposit amount")
        }
    }

    fun displayBalance() {
        println("Hello $customerName!")
        println("Account $accountNumber balance: $balance")
    }

}