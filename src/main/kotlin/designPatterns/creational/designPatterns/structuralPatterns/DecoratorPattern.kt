package org.mentorship2025.designPatterns.creational.designPatterns.structuralPatterns


// Component interface
interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

// Concrete Component
class SimpleCoffee : Coffee {
    override fun getCost(): Double = 1.0
    override fun getDescription(): String = "Simple coffee"
}

// Base Decorator class (optional but good practice)
abstract class CoffeeDecorator(protected val decoratedCoffee: Coffee) : Coffee {
    override fun getCost(): Double = decoratedCoffee.getCost()
    override fun getDescription(): String = decoratedCoffee.getDescription()
}

// It should add 0.5 to the cost.
// It should add ", milk" to the description.
class MilkDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun getCost(): Double = super.getCost() + 0.5
    override fun getDescription(): String = super.getDescription() + ", milk"
}

// It should add 0.2 to the cost.
// It should add ", sugar" to the description.
class SugarDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.2
    }

    override fun getDescription(): String {
        return super.getDescription() + ", sugar"
    }
}


fun main() {
    var coffee: Coffee = SimpleCoffee()
    println("${coffee.getDescription()} costs $${coffee.getCost()}")

    coffee = MilkDecorator(coffee)
    println("${coffee.getDescription()} costs $${coffee.getCost()}")

    coffee = SugarDecorator(coffee)
    println("${coffee.getDescription()} costs $${coffee.getCost()}")
}