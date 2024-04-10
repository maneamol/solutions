package multithreding.reentranklocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private int count = 0;

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting...");
        cond.await();
        System.out.println("Woken up...");
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() {
        lock.lock();
        System.out.println("Waiting for return...");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");
        cond.signal();

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }
    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void finished() {
        System.out.println("Count = " + count);
    }
}
public class ReentrantApp {
    public static void main(String[] args) {
        Runner r = new Runner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.firstThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r.secondThread();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        r.finished();
    }
}
