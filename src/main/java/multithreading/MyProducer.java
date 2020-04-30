package multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyProducer {
    public static void main(String[] args) {
        BlockingQueue abq = new ArrayBlockingQueue<Integer>(10);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                produce(abq);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer(abq);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void produce(BlockingQueue queue){
        Random random = new Random();

        while (true){
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer(BlockingQueue queue){
        while (true){
            try {
                System.out.println(queue.take());
                System.out.println("queue size is " + queue.size());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
