package com.ilkun.delivery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alexander-ilkun
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    public enum OrderType { NEW, IN_PROGRESS, CANCELLED, DONE }

    private static transient final int MAX_NUMBER_OF_PIZZAS = 10;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User customer;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;
    private double price;
    private double discount;
    private int numberOfPizzas;
    @Enumerated(EnumType.STRING)
    private OrderType type;
    
    public Order() {
        this.type = OrderType.NEW;
        this.orderDetails = new ArrayList<>();
    }
    
    public Order(Long id, User customer,
            Address address, Map<Pizza, Integer> pizzas,
            DiscountManager discountManager) {
        this(customer, address, pizzas, discountManager);
        this.id = id;
    }

    public Order(User customer, Address address,
            Map<Pizza, Integer> pizzas, DiscountManager discountManager) {
    }

    public void addPizza(Pizza pizza, int quantity) {
        for (OrderDetails ordDet : orderDetails) {
            if (ordDet.getPizza().equals(pizza)) {
                ordDet.setQuantity(ordDet.getQuantity() + quantity);
                return;
            }
        }
        OrderDetails newDetails = new OrderDetails(this, pizza, quantity, pizza.getPrice());
        orderDetails.add(newDetails);
    }

    public void removePizza(Pizza pizza) {
        Iterator<OrderDetails> it = orderDetails.iterator();
        while(it.hasNext()) {
            if (it.next().getPizza().equals(pizza)) {
                it.remove();
                return;
            }
        }
        orderDetails.remove(pizza);
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
        return super.toString() + "Order{" + "id=" + id + ", customer=" + customer
                + ", address=" + address + ", total=" + getTotalPrice() + 
                ", type=" + type + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public Address getAddress() {
        return address;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
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
