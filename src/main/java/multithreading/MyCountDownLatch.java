package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCountDownLatch {
    public static void main(String[] args) {


        //CountDownLatch - класс, который является 'защелкой обратного отсчета'
        //т.е. как только пройте количество отчетов переданное в качестве аргумента, так сразу
        //программа продолжит работу
        CountDownLatch downLatch = new CountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.submit(new Processor(i, downLatch));
        }

        service.shutdown();

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downLatch.countDown();
            System.out.println("CountDownLatch iterate " + i + " sec");
        }

    }
}
class Processor implements Runnable{
    private int id;
    private CountDownLatch downLatch;

    public Processor(int id, CountDownLatch downLatch) {
        this.id = id;
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            downLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Thread with id " + id + " start");
    }
}