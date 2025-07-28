package org.mentorship2025.designPatterns.creational.designPatterns.creational

/*
Factory Method Pattern
Implement the Factory Method design pattern.

The Factory Method is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

You are given code that includes a few vehicles types and their respective factories. Complete the factory method implementation such that each factory returns the correct vehicle.

Example:

val carFactory: VehicleFactory = CarFactory()
val truckFactory: VehicleFactory = TruckFactory()
val bikeFactory: VehicleFactory = BikeFactory()

val myCar = carFactory.createVehicle()
val myTruck = truckFactory.createVehicle()
val myBike = bikeFactory.createVehicle()

myCar.getType()   // "Car"
myTruck.getType() // "Truck"
myBike.getType()  // "Bike"
*/

// Product interface
interface Vehicle {
    fun getType(): String
}

// Concrete Products
object Car : Vehicle {
    override fun getType(): String = "Car"
}

object Truck : Vehicle {
    override fun getType(): String = "Truck"
}

object Bike : Vehicle {
    override fun getType(): String = "Bike"
}

// Creator interface
interface VehicleFactory {
    fun createVehicle(): Vehicle
}

// Concrete Creators
class CarFactory : VehicleFactory {
    override fun createVehicle(): Vehicle {
        return Car
    }
}

class TruckFactory : VehicleFactory {
    override fun createVehicle(): Vehicle {
        return Truck
    }
}

class BikeFactory : VehicleFactory {
    override fun createVehicle(): Vehicle {
        return Bike
    }
}

fun main() {
    val carFactory: VehicleFactory = CarFactory()
    val truckFactory: VehicleFactory = TruckFactory()
    val bikeFactory: VehicleFactory = BikeFactory()

    val myCar = carFactory.createVehicle()
    val myTruck = truckFactory.createVehicle()
    val myBike = bikeFactory.createVehicle()

    println(myCar.getType())// "Car"
    println(myTruck.getType())// "Truck"
    println(myBike.getType())// "Bike"
}