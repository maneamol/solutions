class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addTwoNumbers(l1, l2, 0)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        return ListNode(sum%10).apply { next = addTwoNumbers(l1?.next, l2?.next, sum/10) }
    }
}