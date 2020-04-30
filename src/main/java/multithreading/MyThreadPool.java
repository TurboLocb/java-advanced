package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        //Создаем пул из 2-ух потоков
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            //Добавляем в пул задания, которые необходимо выполнить
            executorService.submit(new Work(i));
        }
        //Обязательный метод для запуска заданий, без него задания тоже будут выполняться, но после выполнения
        //процесс не закончится
        //аналогичен Thread.start()
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Work implements Runnable{

    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Выполненено задание № " + id );
    }
}
