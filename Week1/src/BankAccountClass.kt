class BankAccountClass(val accountNumber: String, var balance: Double, var customerName: String) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            println("Depositing $amount to account $accountNumber")
            balance += amount
        } else {
            println("Invalid deposit amount")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            println("Withdrawing $amount from account $accountNumber")
            balance -= amount
        } else {
            println("Insufficient funds or invalid withdrawal amount")
        }
    }

    fun displayBalance() {
        println("Account $accountNumber balance: $balance")
    }

}