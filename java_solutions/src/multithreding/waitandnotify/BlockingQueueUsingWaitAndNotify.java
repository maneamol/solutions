package multithreding.waitandnotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class QueueProcessor {
    private Queue<Integer> queue = new LinkedList<>();
    private int LIMIT = 10;
    private Object lock = new Object();
    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }

                queue.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
           synchronized (lock) {
               while (queue.size() == 0) {
                   lock.wait();
               }
               int x = queue.poll();
               System.out.println("x = " + x + " queue size = " + queue.size());
               lock.notify();
           }
           Thread.sleep(random.nextInt(1000));
        }
    }

}
public class BlockingQueueUsingWaitAndNotify {
    private void main() {
        QueueProcessor processor = new QueueProcessor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        BlockingQueueUsingWaitAndNotify obj = new BlockingQueueUsingWaitAndNotify();
        obj.main();
    }
}
