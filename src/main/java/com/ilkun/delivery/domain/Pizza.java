package com.ilkun.delivery.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza implements Serializable{

    public enum PizzaType { VEGETARIAN, SEA, MEAT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private double price;
    
    @Enumerated(EnumType.STRING)
    private PizzaType type;

    public Pizza() {}
    
    public Pizza(Long id, String name, double price, PizzaType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Pizza(String name, double price, PizzaType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pizza other = (Pizza) obj;
        if (name.equals(other.name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }
}
