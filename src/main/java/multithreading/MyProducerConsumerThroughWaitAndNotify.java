package multithreading;

import java.util.*;

public class MyProducerConsumerThroughWaitAndNotify {

    public static void main(String[] args) throws InterruptedException {

        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread1.join();
    }
}

class ProducerConsumer{

    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMiT = 10;
    private final Object synchronizedObj = new Object();

    public void produce() throws InterruptedException {
        int counter = 0;

        while(true){
            synchronized (synchronizedObj){
                while (queue.size() == LIMiT){
                    synchronizedObj.wait();
                }
                queue.offer(counter++);
                synchronizedObj.notify();
            }
        }
    }

    public void consume() throws InterruptedException{
        while (true){
            synchronized (synchronizedObj){
                while (queue.size() == 0){
                    synchronizedObj.wait();
                }

                int value = queue.poll();
                System.out.println(value);
                System.out.println("queue size is " + queue.size());
                synchronizedObj.notify();
            }
            Thread.sleep(1000);
        }
    }
}
