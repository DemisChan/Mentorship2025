package org.mentorship2025.week2.src.main.kotlin

import kotlin.math.abs

/* Find the Missing Number in an Array
Given an array containing n distinct numbers from 0 to n, find the missing number without using extra space.
*/
fun findMissingNumber(arr: IntArray): Int {
    arr.sort()
    val sum = arr.sum()
    val nth = arr.last()
    val sumOfn = nth.times(nth.plus(1)).div(2)
    return sumOfn - sum
}

/*
Check for Balanced Parentheses
Write a function that takes a string containing ()[]{} and checks if the parentheses are balanced.
*/

fun isBalanced(input: String): Boolean {
    var boolean = true
    val bytes = input.toByteArray()
    val br1 = input.count {
        it == '('
    }.compareTo(input.count {
        it == ')'
    })
    val br2 = input.count {
        it == '['
    }.compareTo(input.count {
        it == ']'
    })
    val br3 = input.count {
        it == '{'
    }.compareTo(input.count {
        it == '}'
    })

    return br1 == br2 && br2 == br3
}


fun main() {
    println(findMissingNumber(intArrayOf(3, 0, 1))) // Expected: 2
    println(findMissingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1))) // Expected: 8
    println(findMissingNumber(intArrayOf(0))) // Expected: 1

    println(isBalanced("(]"))
    println(isBalanced("{[}]"))
    println(isBalanced("a(b)c[d]e{f}"))


}
