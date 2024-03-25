import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class DeepCopyList {
    public Node copyRandomList(Node head) {
        // track new node for each node
        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node(1);
        Node temp = dummy;
        Node orig = head;
        while (orig != null) {
            Node n = new Node(orig.val);

            //track
            map.put(orig, n);

            temp.next = n;
            temp = temp.next;
            orig = orig.next;
        }

        Node newNode = dummy.next;
        orig = head;

        while (orig != null) {
            Node rand = orig.random;
            Node newRandom = map.get(rand);
            newNode.random = newRandom;

            orig = orig.next;
            newNode = newNode.next;
        }

        // newNode = dummy.next;
        // orig = head;
        // while (orig != null) {
        //     int origRand = orig.random == null ? -1 : orig.random.val;
        //     int newRand = newNode.random == null ? -1 : newNode.random.val;
        //     System.out.println("orig " + origRand + "  new node " + newRand);
        //     orig = orig.next;
        //     newNode = newNode.next;
        // }

        return dummy.next;


    }

    public static void main(String[] args) {
        DeepCopyList obj = new DeepCopyList();
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        obj.copyRandomList(head);

    }
}
