package multithreding.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
    private int id;
    public Processor(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Starting process " + id);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending process " + id);
    }
}
public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // create thread pool
        for (int i= 0; i < 5; i++) {
            executor.submit(new Processor(i));  // submit 5 jobs of Runnbale
        }
        executor.shutdown();
        System.out.println("All task submitted"); // shutdown threads after eecution

        try {
            executor.awaitTermination(1, TimeUnit.DAYS); //// max wait to finish jobs
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All task completed");
    }
}
