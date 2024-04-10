package multithreding.semaphoreexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection {
    private static Connection instance = new Connection();
    private Connection () {
    }

    private int connections = 0;
    private Semaphore sem = new Semaphore(10, true);
    public void connect() {
        try {
            sem.acquire();
            doConnect();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }
    }

    private void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections (max 10 allowed): " + connections);
        }

        try {
            //do your job
            System.out.println("Working on connections " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        synchronized (this) {
            connections--;
            System.out.println("I'm done " + Thread.currentThread().getName() + " Connection is released , connection count: " + connections);
        }

    }

    public static Connection getInstance() {
        return instance;
    }
}
public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i =0; i< 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
