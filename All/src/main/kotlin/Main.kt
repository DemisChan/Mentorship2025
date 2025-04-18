package org.mentorship2025

import java.io.File
import java.util.Vector
import kotlin.concurrent.thread

fun main() {
    val file = File("C:\\Users\\Gamer\\Downloads\\basedir\\basedir")
    var directoryWithMaxFiles: File? = null
    var count = 0
    file.walkTopDown()
        .filter { it.isDirectory }
        .forEach { dir ->
            val max = dir.listFiles { file -> file.isFile }?.size ?: 0
            if (max > count) {
                count = max
                directoryWithMaxFiles = dir
            }
        }
    println(count)
    println(directoryWithMaxFiles)
}