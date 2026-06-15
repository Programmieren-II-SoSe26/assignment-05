package SynchronizedBank;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;
    private final int id;
    public final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            return;
        }

        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }
}