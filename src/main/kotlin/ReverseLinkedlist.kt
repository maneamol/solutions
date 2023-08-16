class ReverseLinkedlist {
    fun reverseList(head: ListNode?): ListNode? {
        val newHead = ListNode(0)
        val newList = rev(head, newHead)
        return newHead.next
    }

    fun rev(current: ListNode?, newHead: ListNode?): ListNode? {

        if (current == null) {
//            println("returning last")
            return newHead
        }
        val currentNode = current
        val temp = rev(currentNode!!.next, newHead)
//        println("temp= ${temp?.`val` ?: "null temp" } currentNode= ${currentNode?.`val` ?: "null currentNode" }")
        temp?.next = currentNode
        currentNode.next = null
        return currentNode
    }
}

fun main() {
    val rl = ReverseLinkedlist()
    val f = ListNode(1)
    val s = ListNode(2)
    val t = ListNode(3)
    val fo = ListNode(4)
    val fi = ListNode(5)
    f.next = s
    s.next = t
    t.next = fo
    fo.next = fi
    var r = rl.reverseList(f)

    while (r != null) {
        println(r.`val`)
        r = r.next
    }

}