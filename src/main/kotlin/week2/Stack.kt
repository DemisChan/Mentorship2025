interface Stack<Element> {
    fun push(element: Element)
    fun pop(): Element?
}
class StackImpl<T : Any>(): Stack<Any>  {
    private val storage = arrayListOf<Any>()
    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: Any) {
        storage.add(element)
    }
    override fun pop(): Any? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }
}