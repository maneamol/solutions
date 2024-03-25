import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private void addNode(DLinkedNode node) {
        DLinkedNode temp = head.post;

        head.post = node;
        node.post = temp;
        temp.pre = node;
        node.pre = head;

    }

    private void deleteNode(DLinkedNode node) {
        DLinkedNode preTemp = node.pre;
        DLinkedNode postTemp = node.post;

        preTemp.post = postTemp;
        postTemp.pre = preTemp;
    }


    // ----------------
    private int count;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            deleteNode(node);
            addNode(node);
            return;
        }

        if (count == capacity) {
            DLinkedNode n = tail.pre;
            System.out.println("deleting " + n.key);
            deleteNode(n);


            map.remove(n.key);

            count--;
        }
        DLinkedNode node = new DLinkedNode();
        node.key = key;
        node.value = value;
        addNode(node);
        count++;
        map.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(4,4);
//
//        System.out.println(lruCache.get(1));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */