package com.ilkun.delivery.domain;

/**
 *
 * @author alexander-ilkun
 */
public class Pizza {

    public enum PizzaType { VEGETARIAN, SEA, MEAT }

    private Integer id;
    private String name;
    private double price;
    private PizzaType type;

    public Pizza(Integer id, String name, double price, PizzaType type) {
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
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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
