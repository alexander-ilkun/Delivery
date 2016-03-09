package com.ilkun.delivery.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alexander-ilkun
 */
@Entity
@Table(name = "bonus_cards")
public class BonusCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    public BonusCard() {
    }

    public BonusCard(Long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public BonusCard(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
