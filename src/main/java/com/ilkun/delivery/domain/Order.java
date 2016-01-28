package com.ilkun.delivery.domain;

import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class Order {

    public enum OrderType { NEW, IN_PROGRESS, CANCELLED, DONE }
    
    private Integer id;
    private Customer customer;
    private Address address;
    private Map<Pizza, Integer> pizzas;
    private double total;
    private OrderType type;
    
    public Order(Integer id, Customer customer, Address address,
            Map<Pizza, Integer> pizzas, double total, OrderType type) {
        this.id = id;
        this.customer = customer;
        this.address = address;
        this.pizzas = pizzas;
        this.total = total;
        this.type = type;
    }

    public Order(Customer customer, Address address,
            Map<Pizza, Integer> pizzas, double total, OrderType type) {
        this.customer = customer;
        this.address = address;
        this.pizzas = pizzas;
        this.total = total;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer +
                ", address=" + address + ", pizzas=" + pizzas +
                ", total=" + total + ", type=" + type + '}';
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
