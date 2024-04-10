// https://www.youtube.com/watch?v=YdlnEWC-7Wo&list=PLBB24CFB073F1048E
package multithreding.startingthread;

class Runner extends Thread {           // extend the thread class
    @Override
    public void run() {                 //overrride run method
        for (int i = 0; i< 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class StartingThread {
    public static void main(String[] args) {
        Runner runner1 = new Runner();  // create object
        Runner runner2 = new Runner();
        runner1.start();                // start thread by using .start()
        runner2.start();
    }
}