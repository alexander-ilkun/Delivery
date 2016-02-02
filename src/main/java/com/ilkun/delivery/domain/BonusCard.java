package com.ilkun.delivery.domain;

/**
 *
 * @author alexander-ilkun
 */
public class BonusCard {
    
    Integer id;
    double amount;

    public BonusCard(Integer id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public BonusCard(double amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void withdraw(double withdrawAmount) {
        amount -= withdrawAmount;
    }

    public void deposit(double depositAmount) {
        amount += depositAmount;
    }
}
