package multithreading;

import java.util.Scanner;

public class MyVolatile {

    public static void main(String[] args) {
        MyThreadVolatile tread = new MyThreadVolatile();
        tread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        tread.shutDown();
    }

}

class MyThreadVolatile extends Thread{
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            try {
                Thread.sleep(100);
                System.out.println("Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown(){
        this.running = false;
    }
}
