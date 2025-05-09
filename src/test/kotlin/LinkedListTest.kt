import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertNull

/**
 * Tests for the LinkedList class with a focus on the append function.
 * The append function adds a new node with the given value to the end of the list.
 */
class LinkedListTest {

    @Test
    fun `test append to empty list`() {
        val linkedList = LinkedList()
        linkedList.append(5)

        assertEquals(1, linkedList.size)
        assertEquals(5, linkedList.head?.value)
        assertEquals(5, linkedList.tail?.value)
        assertEquals("[5]", linkedList.toString())
    }

    @Test
    fun `test append to non-empty list`() {
        val linkedList = LinkedList()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)

        assertEquals(3, linkedList.size)
        assertEquals(1, linkedList.head?.value)
        assertEquals(3, linkedList.tail?.value)
        assertEquals("[1, 2, 3]", linkedList.toString())
    }

    @Test
    fun `test multiple append calls`() {
        val linkedList = LinkedList()
        linkedList.append(10)
        linkedList.append(20)
        linkedList.append(30)

        assertEquals(3, linkedList.size)
        assertEquals(10, linkedList.head?.value)
        assertEquals(30, linkedList.tail?.value)

        val values = generateSequence(linkedList.head) { it.next }
            .map { it.value }
            .toList()
        assertEquals(listOf(10, 20, 30), values)
    }

    @Test
    fun `test append maintains correct head and tail`() {
        val linkedList = LinkedList()
        linkedList.append(1)
        assertEquals(1, linkedList.head?.value)
        assertEquals(1, linkedList.tail?.value)

        linkedList.append(2)
        assertEquals(1, linkedList.head?.value)
        assertEquals(2, linkedList.tail?.value)

        linkedList.append(3)
        assertEquals(1, linkedList.head?.value)
        assertEquals(3, linkedList.tail?.value)
    }

    @Test
    fun `test append ensures size increment`() {
        val linkedList = LinkedList()
        val initialSize = linkedList.size

        linkedList.append(7)
        assertEquals(initialSize + 1, linkedList.size)

        linkedList.append(8)
        assertEquals(initialSize + 2, linkedList.size)

        linkedList.append(9)
        assertEquals(initialSize + 3, linkedList.size)
    }

    @Test
    fun `test append creates valid string representation`() {
        val linkedList = LinkedList()
        linkedList.append(4)
        linkedList.append(5)
        linkedList.append(6)

        assertEquals("[4, 5, 6]", linkedList.toString())
    }

    @Test
    fun `test append single element multiple times`() {
        val linkedList = LinkedList()
        linkedList.append(42)
        linkedList.append(42)
        linkedList.append(42)

        assertEquals(3, linkedList.size)
        assertEquals(42, linkedList.head?.value)
        assertEquals(42, linkedList.tail?.value)
        assertEquals("[42, 42, 42]", linkedList.toString())
    }

    @Test
    fun `test append to initially empty list works correctly`() {
        val linkedList = LinkedList()
        assertTrue(linkedList.isEmpty())
        assertNull(linkedList.head)
        assertNull(linkedList.tail)

        linkedList.append(15)

        assertFalse(linkedList.isEmpty())
        assertEquals(1, linkedList.size)
        assertEquals(15, linkedList.head?.value)
        assertEquals(15, linkedList.tail?.value)
    }

    @Test
    fun `test getHead returns correct value`() {
        val linkedList = LinkedList()
        linkedList.append(10)
        linkedList.append(20)
        linkedList.append(30)

        assertEquals(10, linkedList.head?.value)
    }

    @Test
    fun `test getHead returns null for empty list`() {
        val linkedList = LinkedList()
        assertNull(linkedList.head?.value)
    }

    @Test
    fun `test reverse returns correct values`() {
        val linkedList = LinkedList()
        linkedList.append(10)
        linkedList.append(20)
        linkedList.append(30)
        linkedList.append(40)

        linkedList.reverse()
        assertEquals(40, linkedList.head?.value)
        assertEquals(30, linkedList.head?.next?.value)
        assertEquals(10, linkedList.tail?.value)
    }
}