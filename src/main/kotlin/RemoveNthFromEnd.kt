class RemoveNthFromEnd {
     fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
          val count = remove(head, n);
          return if (count == n) { head?.next ?: null } else head
     }

     private fun remove(curr: ListNode?, n: Int): Int {
         if (curr == null) return 0
         val count = remove(curr.next, n)
         if (count == n && curr != null) {
              curr.next = curr.next?.next ?: null
         }
         return count + 1
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

//    RemoveNthFromEnd().removeNthFromEnd(f, 5)

    var temp: ListNode? = RemoveNthFromEnd().removeNthFromEnd(f, 5)
    while (temp != null) {
        println(temp.`val`)
        temp = temp.next
    }
}