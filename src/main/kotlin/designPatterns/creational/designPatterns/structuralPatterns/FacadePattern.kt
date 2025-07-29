package org.mentorship2025.designPatterns.creational.designPatterns.structuralPatterns

// Complex Subsystem Parts
class Amplifier {
    fun on() = println("Amplifier on")
    fun off() = println("Amplifier off")
    fun setVolume(level: Int) = println("Amplifier setting volume to $level")
}

class DvdPlayer {
    fun on() = println("DVD Player on")
    fun off() = println("DVD Player off")
    fun play(movie: String) = println("DVD Player playing '$movie'")
}

class Projector {
    fun on() = println("Projector on")
    fun off() = println("Projector off")
    fun wideScreenMode() = println("Projector in widescreen mode")
}

// The Facade
class HomeTheaterFacade(
    private val amp: Amplifier,
    private val dvd: DvdPlayer,
    private val projector: Projector
) {

    // It should turn on the projector, set it to widescreen,
    // turn on the amplifier, set the volume, turn on the DVD player,
    // and start playing the movie.
    fun watchMovie(movie: String){
        projector.on()
        projector.wideScreenMode()
        amp.on()
        amp.setVolume(5)
        dvd.on()
        dvd.play(movie)
    }

    fun endMovie() {
        println("Shutting movie theater down...")
        dvd.off()
        amp.off()
        projector.off()
    }
}

fun main() {
    val facade = HomeTheaterFacade(Amplifier(), DvdPlayer(), Projector())
    facade.watchMovie("Raiders of the Lost Ark")
    println("\n...movie finished...\n")
    facade.endMovie()
}