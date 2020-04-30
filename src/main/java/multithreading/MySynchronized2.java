package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MySynchronized2 {

    private int counter;

    public static void main(String[] args) throws Exception {
        new Worker().main();
    }
}

class Worker {
    Object lock1 = new Object();
    Object lock2 = new Object();

    Random random = new Random();

    private List<Integer> integerList1 = new ArrayList<>();
    private List<Integer> integerList2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integerList1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integerList2.add(random.nextInt(100));
        }
    }

    public void doWork() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();

        //addToList1();
        //addToList2();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
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

        long after = System.currentTimeMillis();

        System.out.println("Time spent: " + (after - before) + " ms");

        System.out.println("List1 : " + integerList1.size());
        System.out.println("List2 : " + integerList2.size());

    }
}
