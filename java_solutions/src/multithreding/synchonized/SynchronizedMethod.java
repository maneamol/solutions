// https://www.youtube.com/watch?v=lotAYC3hLVo&list=PLBB24CFB073F1048E&index=3
package multithreding.synchonized;

public class SynchronizedMethod {
    private int count = 0;
    public static void main(String[] args) {
        SynchronizedMethod app = new SynchronizedMethod();
        app.doWork();

    }
    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i< 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // wait for thread to finish
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }

    private synchronized void increment() {  // synchronized method
        count++;
    }
}
