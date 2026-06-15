package SynchronizedBank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankSimulation {

    public static void main(String[] args) throws InterruptedException {
    }

    public static void testDeposit(BankAccount account) {

        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                account.deposit(1);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        System.out.println("Final balance: " + account.getBalance());
    }

    public static void testTransfer() {
        BankAccount a = new BankAccount(2, 5000);
        BankAccount b = new BankAccount(3, 5000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Bank.transfer(a, b, 10);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Bank.transfer(b, a, 10);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A: " + a.getBalance());
        System.out.println("B: " + b.getBalance());
    }
}