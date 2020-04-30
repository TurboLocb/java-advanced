package multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class MyCallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        
        //под лямбдой Callable<>
        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Thread start");
            Thread.sleep(3000);
            System.out.println("Thread finished");
            return new Random().nextInt(10);
        });

        executorService.shutdown();
        System.out.println(future.get());

    }

    public static int calculate() {
        return 2 + 2;
    }
}
