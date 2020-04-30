package multithreading;

import java.util.Scanner;

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotifyInside wni = new WaitAndNotifyInside();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wni.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wni.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotifyInside{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("producer started");
            wait(); //вводит поток в ожидание
            System.out.println("producer is over");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(3000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for user press key 'Enter'");
            String input = "_";
            while (!((input = scanner.nextLine()).equals(""))){
                System.out.println("You not pressed 'Enter'" + " your symbol is " + input);
            }
            scanner.close();
            System.out.println("Ok, lets go, your key is 'Enter'");

            notify(); //выводит поток из ожидания
        }
    }
}
