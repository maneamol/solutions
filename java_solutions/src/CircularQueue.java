import java.util.Arrays;

public class CircularQueue {
    private int[] queue;
    private int head = 0;
    private int tail = 0;
    private int currentSize = 0;
    private int size =0;

    public CircularQueue(int size) {
        this.queue = new int[size];
        this.currentSize = 0;
        this.size = size;
    }

    private void addQueue(int val) {
        if (currentSize < this.size) {
            queue[head] = val;
            head++;
            currentSize++;
        } else {
            head = (head) % size;
            queue[head] = val;
            head++;
        }
        System.out.print("queue : ");
        for (int i = 0; i< currentSize; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        q.addQueue(1);
        q.addQueue(2);
        q.addQueue(3);
        q.addQueue(4);
        q.addQueue(5);
        q.addQueue(6);
        q.addQueue(7);
    }
}
