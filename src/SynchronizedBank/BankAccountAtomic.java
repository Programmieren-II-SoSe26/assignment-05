package SynchronizedBank;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic extends BankAccount{
    private int balanceAtomic = 0;

    public BankAccountAtomic(int id, int initialBalance) {
        super(id, initialBalance);
        balanceAtomic = initialBalance;
    }

    @Override
    public void deposit(int amount) {
        if (amount < 0) {
            return;
        }

        balanceAtomic += amount;
    }

    @Override
    public boolean withdraw(int amount) {
        if (balanceAtomic >= amount) {
            balanceAtomic -= amount;
            return true;
        }
        return false;
    }

    @Override
    public int getBalance() {
        return balanceAtomic;
    }
}
