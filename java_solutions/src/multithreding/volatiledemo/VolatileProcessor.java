package multithreding.volatiledemo;

import java.util.Scanner;

public class VolatileProcessor extends Thread {
    private volatile boolean running = true; // set volatile to avoid caching
    @Override
    public void run() {
        while (running) {
            System.out.println("!! SHRI GANESHAY NAMAH !!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void shutdown() {
        running = false;
    }

    public static void main(String[] args) {
        VolatileProcessor p1 = new VolatileProcessor();
        p1.start();

        System.out.println("Enter to stop..");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        p1.shutdown();
    }
}
