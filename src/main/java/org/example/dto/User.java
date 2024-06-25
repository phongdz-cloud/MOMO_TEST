package org.example.dto;

public class User extends IdBase {
    private final String username;

    private final Account account;

    public User(int id, String username, String accountNumber, long balance) {
        super(id);
        this.username = username;
        this.account = new Account(this.getId(), accountNumber, balance);
    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }
}
