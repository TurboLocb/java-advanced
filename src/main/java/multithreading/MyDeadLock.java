package multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDeadLock {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finish();
    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Random random = new Random();

    //Deadlock - ситуация при которой локи забираются в разных потоках и код не продолжается
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void locks(Lock lock1, Lock lock2) throws InterruptedException {
        boolean isLock1 = false;
        boolean isLock2 = false;

        while (true) {
            try {
                isLock1 = lock1.tryLock();
                isLock2 = lock2.tryLock();
            } finally {
                if (isLock1 && isLock2) {
                    return;
                }

                if (isLock1) {
                    lock1.unlock();
                }

                if (isLock2) {
                    lock2.unlock();
                }
            }
            Thread.sleep(1);
        }
    }

    public void firstThread() {
        for (int i = 0; i < 10000; i++) {
            try {
                locks(lock1, lock2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        for (int i = 0; i < 10000; i++) {
            try {
                locks(lock2, lock1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void finish() {
        System.out.println("Balance first account: " + account1.getBalance());
        System.out.println("Balance second account: " + account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {

    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account ac1, Account ac2, int amount) {
        ac1.withDraw(amount);
        ac2.deposit(amount);
    }
}
