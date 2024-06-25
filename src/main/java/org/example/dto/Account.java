package org.example.dto;

public class Account{
    private long userId;

    private String accountNumber;

    private long balance;

    public Account(long userId, String accountNumber, long balance) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
