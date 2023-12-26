import java.util.List;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeSortList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newList = new ListNode();
        ListNode newHead = newList;
        ListNode temp;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(new int[]{lists[i].val, i});
            }
        }

        while (!minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            if (lists[arr[1]].next != null) {
                minHeap.offer(new int[]{lists[arr[1]].next.val, arr[1]} );
                lists[arr[1]] = lists[arr[1]].next;
            }
            temp = new ListNode(arr[0]);
            newList.next = temp;
            newList = newList.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] arr = {head1, head2, head3};

        MergeSortList obj = new MergeSortList();
//        obj.mergeKLists(arr);
        ListNode[] arr1 = new ListNode[1];
        obj.mergeKLists(arr1);
    }
}
