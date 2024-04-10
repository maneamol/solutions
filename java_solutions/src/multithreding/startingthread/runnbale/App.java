// https://www.youtube.com/watch?v=YdlnEWC-7Wo&list=PLBB24CFB073F1048E
package multithreding.startingthread.runnbale;

class Runner implements Runnable {                  // implement Runnable interface

    @Override
    public void run() {                             // ovveride run method
        for (int i =0; i < 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());       // pass Runnable object to Thread
        Thread t2 = new Thread(new Runner());

        t1.start();                                 // start thread
        t2.start();
    }
}
