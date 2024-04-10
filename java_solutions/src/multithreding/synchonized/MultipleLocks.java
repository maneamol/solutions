// https://www.youtube.com/watch?v=8sgDgXUUJ68&list=PLBB24CFB073F1048E&index=4
package multithreding.synchonized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocks {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();  // lock object
    private Object lock2 = new Object();

    private void stageOne() {
        synchronized (lock1) {           // synchronize on objects
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(99));
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(99));
        }
    }

    private void process() {
        for (int i = 0; i< 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    private void main() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("list1 = " + list1.size() + " list2 = " + list2.size() + " time = " + (end - start));
    }

    public static void main(String[] args) {
        MultipleLocks multipleLocks = new MultipleLocks();
        for (int i = 0; i < 100; i++) {
            multipleLocks.main();
        }
    }
}
