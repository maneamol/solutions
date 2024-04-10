package maxstack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Node {
    int data;
    Node next;
    Node pre;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
}
class MaxStack {
    TreeMap<Integer, List<Node>> tmap;
    Node head;
    Node tail;

    public MaxStack() {
        tmap = new TreeMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.pre = head;
    }

    private Node addTop(int x) {
        Node tmp = new Node(x);

        Node prev = tail.pre;
        tmp.next = tail;
        tail.pre = tmp;

        prev.next = tmp;
        tmp.pre = prev;

        return tmp;
    }

    private Node getTop() {
        if (tmap.size() == 0) {
            return null;
        }
        return tail.pre;
    }

    private void remove(Node tmp) {
        Node prev = tmp.pre;
        Node nextNode = tmp.next;

        prev.next = nextNode;
        nextNode.pre = prev;
    }

    public void push(int x) {
        Node node = addTop(x);
        tmap.computeIfAbsent(x , k -> new ArrayList<Node>()).add(node);
    }

    public int pop() {
        Node high = getTop();
        if (high == null) {
            return -1;
        }
        remove(high);
        List al = tmap.get(high.data);
        al.remove(al.size() - 1 );
        if (al.size() == 0) {
            tmap.remove(high.data);
        }
        return high.data;
    }

    public int top() {
        Node high = getTop();
        if (high == null) {
            return -1;
        }
        return high.data;
    }

    public int peekMax() {
        int max = tmap.lastKey();
        return max;
    }

    public int popMax() {
        int x = tmap.lastKey();
        List<Node> al = tmap.get(x);
        Node tmp = al.remove(al.size() - 1);
        remove(tmp);
        if (al.size() == 0) {
            tmap.remove(x);
        }
        return x;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */