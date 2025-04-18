data class ListNode(var value: Int) {
    var next: ListNode? = null
}

class LinkedList {
    var head: ListNode? = null
    var tail: ListNode? = null
    var size = 0
    fun isEmpty() = size == 0
    fun append(value: Int) {
        val newNode = ListNode(value)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        size++
    }

    fun pop(): Int? {
        if (isEmpty()) return null
        val result = head?.value
        head = head?.next
        if (isEmpty()) tail = null
        size--
        return result
    }

    fun insert(index: Int, value: Int) {
        if (index < 0 || index > size) throw IndexOutOfBoundsException()
        val newNode = ListNode(value)
        if (index == 0) {
            newNode.next = head
            head = newNode
            return
        }
        var currentNode = head
        for (i in 1 until index) {
            currentNode = currentNode?.next
        }

        newNode.next = currentNode?.next
        currentNode?.next = newNode
        size++
    }

    fun remove(index: Int): Int? {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException()
        if (index == 0) return pop()
        var currentNode = head
        var i = 0
        while (i < index - 1) {
            currentNode = currentNode?.next
            i++
        }
        val result = currentNode?.next?.value
        currentNode?.next = currentNode.next?.next
        size--
        return result
    }

    // Reversed Linked List
    fun reverse() {
        if (size <= 1) return

        tail = head
        var prev: ListNode? = null
        var current = head
        var next: ListNode?

        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        head = prev
    }

    override fun toString(): String {
        if (isEmpty()) return "[]"
        val result = StringBuilder("[")
        var current = head
        while (current != null) {
            result.append(current.value)
            if (current.next != null) {
                result.append(", ")
            }
            current = current.next
        }
        result.append("]")
        return result.toString()
    }
}



fun main() {
    val list = LinkedList()

    list.append(1)

    list.append(2)

    list.append(3)

    list.insert(0, 0)
    println(list)
    list.reverse()
    println(list)
}