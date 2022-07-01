package com.path.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    private Account account;

    private float amount;

    public Transaction() {

    }

    public Transaction(Account account, float amount) {
        this.account = account;
        this.amount = amount;
    }

    public Integer getAccountId() {
        return this.account.getId();

    }

    public int getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }
}
