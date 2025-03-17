package collectionsHighOrderFunctions

// create list of integers
val numbers = listOf(3, 5, 3, 8, 9, 10, 7)
val numbers2 = listOf(1, 2, 2, 3, 3, 4)

// Task 1
fun removeDuplicates(list: List<Int>): List<Int> {

    return list.distinct()
}


fun removeDuplicatesManual(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list) {
        if (i !in result) {
            result.add(i)
        }
    }
    return result
}

// Task 2
fun sumNonAdjacentElements(list: List<Int>): Int {
    var sumEven = 0
    var sumOdd = 0
    val indList = list.indices.toList()
    for (i in indList) {
        if (i % 2 == 0) {
            sumEven += list[i]
        } else {
            sumOdd += list[i]
        }
    }
    sumEven.compareTo(sumOdd).apply {
        return if (this == 1) {
            sumEven
        } else {
            sumOdd
        }
    }
}

// Task 3
fun numberOfOccurrences(list: List<Int>): Map<Int, Int> {
    val result = mutableMapOf<Int, Int>()
    for (i in list) {
        result[i] = list.count { it == i }
    }
    return result
}

// Task 4
fun textToUppercase(list: List<String>): List<String> {
    return list.map { it.uppercase() }
}

// Task 5
fun mergedAndSorted(list1: List<Int>, list2: List<Int>): List<Int> {
    return list1.plus(list2).sortedDescending().reversed()

}


// My practice
// Given a list of strings, create a new list containing the uppercase version of each string.
val words = listOf("apple", "banana", "cherry")
val wordsUppercase = words.map { it.uppercase() }

// Given a list of Person objects (with name and age properties),
// create a list containing only the names of the people.
data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 30),
    Person("Bob", 25),
    Person("Charlie", 35)
)
val names = people.map { it.name }

// Given a list of numbers, calculate the average of the numbers using fold.
val numbers3 = listOf(10, 20, 1, 40, 50)
val avg = numbers3.fold(0) { acc, i -> acc + i.div(numbers3.size) }

// Given a list of strings, create a single string that contains all the
// strings concatenated, separated by spaces, but only include strings with length greater than 3.
val words2 = listOf("cat", "dog", "elephant", "bird", "giraffe")
val result = words2.filter { it.length> 3 }.fold("") { acc, i ->
    acc.plus(i).plus(" ")
}

// Given a list of numbers, find the smallest number using reduce.
val min = numbers3.reduce{acc, i -> if (acc < i) acc else i}

// Given a list of strings, find the longest string using reduce
val longestString = words2.reduce { acc, s -> if (acc.length > s.length) acc else s  }



fun main() {
    // task 1
    println(removeDuplicates(numbers))
    println(removeDuplicatesManual(numbers))

    // task 2
    println(sumNonAdjacentElements(numbers))

    //task 3
    println(numberOfOccurrences(numbers2))

    //task 4
    println(textToUppercase(listOf("hello", "world", "kotlin")))

    //task 5
    println(mergedAndSorted(numbers, numbers2))

    // Mine
    println(wordsUppercase)
    println(names)
    println(avg)
    println(result)
    println(min)
    println(longestString)
}


