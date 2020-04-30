package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore {
    public static void main(String[] args) throws InterruptedException {
        /*Semaphore semaphore = new Semaphore(2); //кол-во разрешений

        try {
            semaphore.acquire(); //запроси разрешения
            semaphore.acquire(); //запроси разрешения
            semaphore.acquire(); //запроси разрешения
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release(); //вызываем,когда заканчиваем юзать ресурс

        System.out.println(semaphore.availablePermits()); //возвращаем кол-во допущенных разрешений*/

        ExecutorService service = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();

        for (int i = 0; i < 200; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
    }
}

//класс сделан по паттерну singleton
class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        //System.out.println("This method using current thread " + Thread.getAllStackTraces().getClass().getName());

        synchronized (this) {
            connectionsCount++;
            System.out.println("Number of connections: " + connectionsCount);
        }

        Thread.sleep(5000);

        synchronized (this) {
            System.out.println("Work was completed");
            connectionsCount--;
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
