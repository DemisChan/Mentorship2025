package org.mentorship2025

import java.io.File

//fun runningSum(nums: IntArray): IntArray {
//    val ind = nums.indices
//    val ar = IntArray(nums.size)
//    for ((i, j) in nums.zip(ind)) {
//        if (j == 0) {
//            ar[j] = i
//            continue
//        }
//        ar[j] = i + ar[j - 1]
//    }
//    return ar
//}

fun runn(nums: IntArray): Any {
    if (nums.isEmpty()) return emptyArray<Int>()

    val result = IntArray(nums.size)

    nums.foldIndexed(0) { index, acc, value ->
        println("$value, $acc")
        val newSum = acc + value
        result[index] = newSum
        newSum
    }

    return result.contentToString()
}

fun runningSum(nums: IntArray): IntArray {
    return nums.runningReduce { sum, element -> sum + element }.toIntArray()
}

fun maxProfit(prices: IntArray): Int {
    prices.foldIndexed<Int>(prices[0]) { i, min, n ->
        prices[i] = n - min
        if (n < min) n else min
    }
    return prices.max() ?: 0
}



fun main() {
//    val file = File("C:\\Users\\Gamer\\Downloads\\basedir\\basedir")
//    var directoryWithMaxFiles: File? = null
//    var count = 0
//    file.walkTopDown()
//        .filter { it.isDirectory }
//        .forEach { dir ->
//            val max = dir.listFiles { file -> file.isFile }?.size ?: 0
//            if (max > count) {
//                count = max
//                directoryWithMaxFiles = dir
//            }
//        }
//    println(count)
//    println(directoryWithMaxFiles)

    println(runningSum(intArrayOf(1, 2, 3, 4)).contentToString())
    println(runn(intArrayOf(1, 2, 3, 4)))
}