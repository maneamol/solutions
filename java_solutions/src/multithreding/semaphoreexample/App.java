package multithreding.semaphoreexample;

import java.util.concurrent.Semaphore;


class H2O {
    Semaphore sh;
    Semaphore so;

    public H2O() {
        sh = new Semaphore(2);
        so = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        System.out.println("test");
        sh.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        so.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        so.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        sh.release(2);
    }
}

public class App {

    public static void main(String[] args) throws InterruptedException {
        H2O h2o = new H2O();
        for (int i =0 ; i< 10; i++) {
            h2o.hydrogen(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

        for (int i =0 ; i< 5; i++) {
            h2o.oxygen(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

    }
}

/**

 public class H2O {

 private int hydrogenCount;
 private int oxygenCount;

 public H2O() {
 hydrogenCount = 0;
 oxygenCount = 0;
 }

 public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
 while (hydrogenCount == 2 && oxygenCount == 0) {
 wait();
 }
 hydrogenCount++;
 releaseHydrogen.run();
 if (hydrogenCount == 2 && oxygenCount == 1) {
 hydrogenCount = oxygenCount = 0;
 notifyAll();
 }

 }

 public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
 while (hydrogenCount < 2 && oxygenCount == 1) {
 wait();
 }
 oxygenCount++;
 releaseOxygen.run();
 if (hydrogenCount == 2 && oxygenCount == 1) {
 hydrogenCount = oxygenCount = 0;
 notifyAll();
 }
 }
 }

 */
