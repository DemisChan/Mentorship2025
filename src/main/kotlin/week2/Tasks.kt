package org.mentorship2025.week2

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

/*
Find the Longest Substring Without Repeating Characters
Given a string, return the length of the longest substring without repeating characters.
Example: "abcabcbb" → 3
*/

fun lengthOfLongestSubstring(s: String): Int {
    var longest = 0
    var start = 0
    if (s.isEmpty()) return 0

    val lastSeen = HashMap<Char, Int>()
    for (end in s.indices) {
        val currentChar = s[end]
        if (lastSeen.contains(currentChar) && lastSeen[currentChar]!! >= start) {
            start = lastSeen[currentChar]!! + 1
        } else {
            longest = maxOf(longest, end - start + 1)
        }
        lastSeen[currentChar] = end
    }
    return longest
}

/*
Maximum Value in K-sized Window
Given an array and an integer k, return the maximum value in every k-sized window.
 */

fun maxValue(arr: IntArray, k: Int): List<Int> {
    var temp = k
    val result = IntArray(arr.size - k + 1)
    for (i in 0..arr.size - k) {
        if (temp <= arr.size) {
            val x = arr.slice(i until temp)
            result[i] = x.max()
            temp += 1
        }
    }
    return result.toList()
}

// kotlin way
fun maxValueWindowed(arr: IntArray, k: Int): List<Int> {
    if (arr.isEmpty() || k <= 0 || k > arr.size) {
        return emptyList()
    }

    return arr.asSequence()
        .windowed(size = k, step = 1)
        .map { it.maxOrNull() ?: 0 }
        .toList()
}




fun main() {
    println(findMissingNumber(intArrayOf(3, 0, 1))) // Expected: 2
    println(findMissingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1))) // Expected: 8
    println(findMissingNumber(intArrayOf(0))) // Expected: 1

    println(isBalanced("(]"))
    println(isBalanced("{[}]"))
    println(isBalanced("a(b)c[d]e{f}"))


    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("abcdefggghjjkiolslkjhbfdljdhvbasdf"))
    println(lengthOfLongestSubstring(""))


    println(maxValue(intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20), 4))
    println(maxValueWindowed(intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20), 4))
    println(maxValue(intArrayOf(5, 4, 3, 2, 1), 3))

}
