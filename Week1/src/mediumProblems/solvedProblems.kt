package mediumProblems

import lambdasAndScopeFunctions.Person

/*Sum of List using fold: Write a function that takes a list of integers and uses
the fold function to calculate the sum of all the elements in the list.*/
fun sumOfList(list: List<Int>): Int {
    return list.fold(0) { acc, i ->
        acc + i
    }
}

/*
Remove Duplicates with distinct:
Write a function that takes a list of integers and removes duplicate elements using the distinct function.
*/
fun removeDuplicates(list: List<Int>): List<Int> {
    return list.distinct()
}

/*Implement map using forEach: Write a function that mimics the behavior of the
map function without using map. Use a forEach loop to transform a list of integers by multiplying each element by 3.*/
fun mapWithForEach(list: List<Int>) {
    val result = mutableListOf<Int>()
    list.forEach {
        result.add(it * 3)
    }
}

/*
Count Occurrences of Elements: Write a function that counts the occurrences of each
unique element in a list of integers and returns a map of the element to its count.
*/
fun countOccurrences(list: List<Int>): Map<Int, Int> {
    // Already done in previous task
    return emptyMap()
}

/*
Filter Even Numbers Using Lambdas: Write a function
that filters all even numbers from a list using a lambda expression and returns a list of only even numbers.
*/
fun filterEvenNumbers(list: List<Int>): List<Int> {
    return list.filter { it % 2 == 0 }
}

/*Convert a List of Strings to Integers: Write a
function that takes a list of strings representing integers and converts each element to an integer using the map function.*/
fun convertStringToIntegers(list: List<String>): List<Int> {
    return list.map { it.toInt() }
}

/*Implement flatMap: Write a function that takes a
list of lists of integers and uses flatMap to create a single list that contains all elements from all the lists.*/
fun flatMap(list: List<List<Int>>): List<Int> {
    return list.flatMap { it }
}

/*
Find the Maximum Element in a List: Write a function that uses a
combination of the reduce function and a lambda expression to find the maximum number in a list of integers.
*/
fun findMax(list: List<Int>): Int {
    return list.reduce { acc, i -> if (acc > i) acc else i }
}

/*Use apply to Create a Custom Object: Create a custom
Person class with properties name and age. Write a function that uses apply to initialize a Person object and return it.*/
fun Person.createPerson(init: Person.() -> Unit): Person {
    return apply(init)
}

fun createPerson(pName: String, pAge: Int ): Person {
    return Person().apply {
        name = pName
        age = pAge
    }

}

/*Calculate Factorial Using Recursion: Write a function that calculates the factorial of a number using recursion.
Then, use a lambda function to perform the recursive calculation.*/
fun factorial(num: Int): Int {
    if(num == 0 || num == 1) {
        return 1
    }
    return num * factorial(num - 1)
}


fun main() {
    println(
        mapWithForEach(
            listOf(1, 2, 3)
        )
    )
    println(filterEvenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println(flatMap(listOf(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9))))
    println(findMax(listOf(1, 2, 3, 4, 5, 20, 7, 8, 9, 10)))
    println(Person().createPerson {
        name = "Demis"
        age = 41
    })
    println(createPerson("Demis", 41))
    println(factorial(3))
}