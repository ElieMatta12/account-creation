package com.path.transaction;

import com.path.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class AccountResponse {

    private String name;
    private String surname;
    private float balance;

    private List<Transaction> transactions = new ArrayList<>();

    public AccountResponse(String name, String surname, float balance, List<Transaction> transactions) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
