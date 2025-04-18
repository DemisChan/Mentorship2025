package studentGrading

class Student(val name: String, private val grades: List<Int>) : Comparable<Student> {

    fun calculateAverage(): Double {
        // grades.average() easy way
        return grades.sumOf { it.toDouble() }.div(grades.size)
    }

    fun gradeCategory() {
        val categoryGrades = mutableListOf<String>()
        grades.forEach {
            when (it) {
                in 0..5 -> categoryGrades.add("E")
                in 6..9 -> categoryGrades.add("D")
                in 10..14 -> categoryGrades.add("C")
                in 15..17 -> categoryGrades.add("B")
                else -> categoryGrades.add("A")
            }
        }
        println(categoryGrades.joinToString(separator = ",", prefix = "Grades: "))
    }

    override fun compareTo(other: Student): Int {
        return grades.average().compareTo(other.grades.average())
    }

}


fun main() {
    // Student Grades
    val gradesA = listOf(10, 18, 20, 15)
    val gradesB = listOf(11, 8, 18, 19)
    val studentA = Student("Demis Lavrentidis", gradesA)
    val studentB = Student("Rey Rey", gradesB)

    println(studentA.calculateAverage())
    println(studentB.calculateAverage())

    studentA.gradeCategory()
    studentB.gradeCategory()
    if (studentA > studentB) {
        println("${studentA.name} has higher average grade than ${studentB.name}")
    } else {
        println("${studentB.name} has higher average grade than ${studentA.name}")
    }


}
