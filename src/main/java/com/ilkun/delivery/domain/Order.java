package com.ilkun.delivery.domain;

import com.ilkun.delivery.infrastructure.annotations.MyComponent;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
@MyComponent
public class Order {

    public enum OrderType { NEW, IN_PROGRESS, CANCELLED, DONE }

    private static final int MAX_NUMBER_OF_PIZZAS = 10;
    
    private Integer id;
    private Customer customer;
    private Address address;
    private Map<Pizza, Integer> pizzas;
    private double price;
    private double discount;
    private int numberOfPizzas;
    private OrderType type;
    
    public Order() {}
    
    public Order(Integer id, Customer customer,
            Address address, Map<Pizza, Integer> pizzas,
            DiscountManager discountManager) {
        this(customer, address, pizzas, discountManager);
        this.id = id;
    }

    public Order(Customer customer, Address address,
            Map<Pizza, Integer> pizzas, DiscountManager discountManager) {
        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            numberOfPizzas += entry.getValue();
            price += entry.getKey().getPrice() * entry.getValue();
            if (numberOfPizzas > MAX_NUMBER_OF_PIZZAS) {
                throw new IllegalArgumentException("Number of pizzas can not "
                        + "be more than " + MAX_NUMBER_OF_PIZZAS);
            }
        }
        this.customer = customer;
        this.address = address;
        this.pizzas = pizzas;
        this.type = OrderType.NEW;
        this.discount = discountManager.getDiscount(this);
    }

    public void changeType(OrderType newType) {
        if (newType.ordinal() >= type.ordinal()
                && !type.equals(OrderType.CANCELLED)) {
            type = newType;
        } else {
            throw new IllegalArgumentException("Can not change order type from "
                    + type + " to " + newType);
        }
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer
                + ", address=" + address + ", pizzas=" + pizzas
                + ", total=" + getTotalPrice() + ", type=" + type + '}';
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

    public Address getAddress() {
        return address;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalPrice() {
        return price - discount;
    }

    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
