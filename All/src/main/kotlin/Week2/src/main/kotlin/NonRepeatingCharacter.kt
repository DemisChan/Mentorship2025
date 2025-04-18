/*
Write a function that takes a string and returns the first non-repeating character.
Example: "swiss" → 'w'
* */
fun firstNonRepeatingCharacter(input: String): Char {
    var temp = input
    val indices = temp.indices
    var nonRepeatingChar = '_'
    for (i in indices) {
        val x = input[i]
        temp = input.removeRange(i, i + 1)
        if (x !in temp) {
            nonRepeatingChar = x
            break

        }
    }
    return nonRepeatingChar
}

fun main() {
    val result1 = firstNonRepeatingCharacter("swiss")
    println(result1) // Expected output: 'w'
    val result2 = firstNonRepeatingCharacter("google")
    println(result2) // Expected output: 'l'

}