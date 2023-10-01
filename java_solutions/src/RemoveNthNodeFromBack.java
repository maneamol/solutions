//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromBack {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode frontPointer = head;
        ListNode backPointer = head;

        while (n > 0 && frontPointer != null) {
            frontPointer = frontPointer.next;
            n--;
//            System.out.println(frontPointer.val + " " + n);
        }
        if (frontPointer == null && n > 0) {
            return head;
        }
        if (frontPointer == null && n ==0 ) {
            return head.next;
        }
        while (frontPointer != null && frontPointer.next !=null) {
            frontPointer = frontPointer.next;
            backPointer = backPointer.next;
        }

//        if (backPointer == head) {
//            return head.next;
//        }
        backPointer.next = backPointer.next.next;
        return head;
    }

    private void test() {
        ListNode f = new ListNode(1);
//        ListNode s = new ListNode(2);
//        ListNode t = new ListNode(3);
//        ListNode fo = new ListNode(4);
//        ListNode fi = new ListNode(5);
//        f.next = s;
//        s.next = t;
//        t.next = fo;
//        fo.next = fi;
//        fi.next = null;

        removeNthFromEnd(f, 1);

    }

    public static void main(String[] args) {
        RemoveNthNodeFromBack removeNthNodeFromBack = new RemoveNthNodeFromBack();
        removeNthNodeFromBack.test();;
    }

}
