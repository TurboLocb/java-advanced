package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.first();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.second();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(task.toString());

    }
}

class Task{
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment(){
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    public void first(){
        lock.lock();
        increment();
        lock.unlock();
    }

    public void second(){
        lock.lock();
        increment();
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Task{" +
                "counter=" + counter +
                '}';
    }
}
