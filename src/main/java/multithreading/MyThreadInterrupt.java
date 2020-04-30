package multithreading;

import java.util.Random;

public class MyThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Thread sinThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println(Thread.currentThread().getName() + " was interrupted");
                        break;
                    }
                    /*try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread().getName() + " was interrupted by 'try->catch interrupted'");
                        break;
                    }*/
                    System.out.println(Math.sin(random.nextDouble()));
                }
            }
        });
        sinThread.setName("SinThread");

        System.out.println("Sin thread start");
        sinThread.start();

        Thread.sleep(1000);

        sinThread.interrupt();
        sinThread.join();

        System.out.println("Sin thread finished");
    }
}
