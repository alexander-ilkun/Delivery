package com.ilkun.delivery.domain;

import com.ilkun.delivery.domain.discount.DiscountManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    public enum OrderType { NEW, IN_PROGRESS, CANCELLED, DONE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetails;
    private double price;
    private double discount;
    @Enumerated(EnumType.STRING)
    private OrderType type;
    
    public Order() {
        this.type = OrderType.NEW;
        this.orderDetails = new ArrayList<>();
    }
    
    public Order(Long id, User customer,
            Address address, Map<Pizza, Integer> pizzas,
            DiscountManager discountManager) {
        this(customer, address, pizzas);
        this.id = id;
    }

    public Order(User customer, Address address,
            Map<Pizza, Integer> pizzas) {
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
    }

    public void checkout(DiscountManager discountManager) {
        price = 0.0;
        for (OrderDetails ordDet : orderDetails) {
            price += ordDet.getQuantity() * ordDet.getPizzaPrice();
        }
        discount = discountManager.getDiscount(this);
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
        return "Order{" + "id=" + id + ", user=" + user
                + ", address=" + address + ", total=" + getTotalPrice() + 
                ", type=" + type + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return price - discount;
    }

    public int getNumberOfPizzas() {
        int numberOfPizzas = 0;
        for (OrderDetails ordDet : orderDetails) {
            numberOfPizzas += ordDet.getQuantity();
        }
        return numberOfPizzas;
    }

    public OrderType getType() {
        return type;
    }

    private void setType(OrderType type) {
        this.type = type;
    }
}
