interface Queue<T> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}


class ArrayListQueue<T> : Queue<T> {
    private val list = arrayListOf<T>()

    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)
}

fun main() {
    val queue = ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(queue.peek())
    queue.dequeue()
    println(queue.peek())
    println("Next up: ${queue.peek()}")
}