package multithreading;

public class MySynchronized {

    private int counter;

    public static void main(String[] args) {
        MySynchronized mySynchronized = new MySynchronized();
        try {
            mySynchronized.doIncrement();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void counterSynchronized(){
        counter++;
    }

    public void doIncrement() throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    counterSynchronized();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    counterSynchronized();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Счетчик равен: " + counter);
    }
}
