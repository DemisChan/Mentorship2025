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
}


