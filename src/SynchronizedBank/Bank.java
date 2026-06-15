package SynchronizedBank;

import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    public static void transfer(BankAccount from, BankAccount to, int amount) {

        from.lock.lock();
        try {
            to.lock.lock();
            try {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                }
            } finally {
                to.lock.unlock();
            }
        } finally {
            from.lock.unlock();
        }
    }
}