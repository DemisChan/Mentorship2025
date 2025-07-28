import org.mentorship2025.week2.maxValueWindowed
import kotlin.collections.maxOrNull
import kotlin.sequences.map
import kotlin.sequences.toList
import kotlin.sequences.windowed


fun isValid(s: String): Boolean {
    if (s.length % 2 != 0) return false

    val sDeque = ArrayDeque<Char>(s.length / 2)
    var t = 0
    s.forEach {

        when (it) {
            '(', '[', '{' -> {
                t += 1
                sDeque.addLast(it)
            }

            ')' -> {
                t -= 1
                if (sDeque.isEmpty() || sDeque.removeLast() != '(') return false
            }

            ']' -> {
                t -= 1
                if (sDeque.isEmpty() || sDeque.removeLast() != '[') return false
            }

            '}' -> {
                t -= 1
                if (sDeque.isEmpty() || sDeque.removeLast() != '{') return false
            }
        }
    }
    return if (t == 0) {
        true
    } else {
        false
    }

}

fun main() {
    val x = isValid("[[")
    print(x)
}