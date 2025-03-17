package lambdasAndScopeFunctions

// task 1
//Question: You have a list of integers: val numbers = listOf(1, 2, 3, 4, 5).
//Write a function that uses the let scope function to transform each element of the list by multiplying it by 2.
//Return the transformed list.
//Hint: Use the let function to operate on each number and return a new list with the results.
val numbers = listOf(1, 2, 3, 4, 5)
fun transformList(list: List<Int>) = list.let { ints ->
    ints.map { it * 2 }
}

// task 2
/*
Using apply for Object Initialization
Question: Create a Person class with the properties name and age. Then, write a function that uses the apply scope function to initialize a Person object and set its properties.
Hint: The apply function is often used for initializing objects where you want to set multiple properties.
*/
data class Person(var name: String = "", var age: Int = 0)

val demis = Person().apply {
    name = "Demis"
    age = 24
}

// task 3
/*
Question: Write a function that takes a string as an input, checks if it is not empty, and if not, calculates the length of the string. Use the run function to handle the computation and return the length if the string is not empty. If the string is empty, return -1.
Hint: run is used for executing a block of code and returning the result.
*/
fun stringLength(str: String): Int = str.run {
    if (isEmpty()) {
        -1
    } else {
        length
    }
}


fun main() {
    println(transformList(numbers))
    println(demis)
    println(stringLength("Lavrentidis"))
    println(stringLength(""))
}