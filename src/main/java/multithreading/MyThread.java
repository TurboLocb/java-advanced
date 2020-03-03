package multithreading;

public class MyThread extends Thread {
    public static void main(String[] args) {

        Thread thread = new MyThread();
        thread.start();

        Thread thread1 = new Thread(new MyRunner());
        thread1.start();

        System.out.println("Message from thread: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Message from thread: " + Thread.currentThread().getName());
    }
}

class MyRunner implements Runnable{
    @Override
    public void run() {
        Thread.currentThread().setName("MyRunner");
        System.out.println("Message from thread: " + Thread.currentThread().getName());
    }
}
