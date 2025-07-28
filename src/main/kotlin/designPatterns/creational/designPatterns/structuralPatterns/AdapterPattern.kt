package org.mentorship2025.designPatterns.creational.designPatterns.structuralPatterns

/*Create a SocketAdapter that allows a EuropeanAppliance (which needs a EuropeanSocket)
to be plugged into a USAPowerOutlet (which only provides a USASocket)*/

// Implement the Adapter class.
// It should implement the USASocket interface.
// It should hold a reference to a EuropeanSocket object (the adaptee).
// Its provideUSAPower() method should delegate the call to the adaptee's
// provideEuropeanPower() method.

interface EuropeanSocket {
    fun provideEUPower()
}

interface USASocket {
    fun provideUsaPower()
}

class SocketAdapter(private val europeanSocket: EuropeanSocket) : USASocket {
    override fun provideUsaPower() {
        europeanSocket.provideEUPower()
    }
}

class EuropeanAppliance(private val socket: EuropeanSocket) {
    fun turnOn() {
        socket.provideEUPower()
        println("European appliance is now running!")
    }
}

class USAPowerOutlet {
    fun plugIn(socket: USASocket) {
        println("USA Outlet: Plugging in a USA socket.")
        socket.provideUsaPower()
    }
}

fun main() {
    // We have a European appliance and a US outlet. They are incompatible.
    val appliance = EuropeanAppliance(object : EuropeanSocket {
        override fun provideEUPower() {
            println("Providing European standard power.")
        }
    })

    val usaOutlet = USAPowerOutlet()

    // We can't do this:
    // usaOutlet.plugIn(appliance.socket) // Type mismatch

    // But we can use our adapter
    val adapter = SocketAdapter(object : EuropeanSocket {
        override fun provideEUPower() {
            println("Providing European standard power through adapter.")
        }
    })

    println("Plugging appliance into USA outlet using an adapter...")
    usaOutlet.plugIn(adapter)
    // Now we can conceptually use the appliance
    appliance.turnOn() // This part is just for concept, the main test is plugging in.
}