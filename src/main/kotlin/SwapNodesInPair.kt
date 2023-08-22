class SwapNodesInPair {
    fun swapPairs(head: ListNode?): ListNode? {
        if(head == null) return null
        return head.next?.let { nextNode ->
            val veryNext = nextNode.next
            nextNode.next = head
            head.next = swapPairs(veryNext)
            return nextNode
        } ?: head
    }
}

fun main() {
    val f = ListNode(1)
    val s = ListNode(2)
    val t = ListNode(3)
    val fo = ListNode(4)
    val fi = ListNode(5)
    f.next = s
    s.next = t
    t.next = fo
    fo.next = fi
    val snp = SwapNodesInPair()
    var newNode: ListNode? =  snp.swapPairs(f)

//    while (newNode != null) {
//        println(newNode.`val`)
//        newNode = newNode?.next ?: null
//    }
}