package collectionsHighOrderFunctions

// create list of integers
val numbers = listOf(3, 5, 3, 8, 9, 10, 7)

// Task 1
fun removeDuplicates(list: List<Int>): List<Int> {

    return list.distinct()
}

fun removeDuplicatesManual(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for(i in list) {
        if(i !in result) {
            result.add(i)
        }
    }
    return result
}

// Task 2
fun sumNonAdjacentElements(list: List<Int>): Int {
    var sumEven  = 0
    var sumOdd = 0
    val indList = list.indices.toList()
    for (i in indList) {
        if( i% 2 == 0) {
            sumEven += list[i]
        }
        else {
            sumOdd += list[i]
        }
    }
    sumEven.compareTo(sumOdd).apply {
        return if(this == 1) {
            sumEven
        } else {
            sumOdd
        }
    }
}

fun main() {
    // task 1
    println(removeDuplicates(numbers))
    println(removeDuplicatesManual(numbers))

    // task 2
    println(sumNonAdjacentElements(numbers))
}


