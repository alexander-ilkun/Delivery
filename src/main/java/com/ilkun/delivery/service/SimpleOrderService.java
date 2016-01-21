package com.ilkun.delivery.service;

import com.ilkun.delivery.entity.Customer;
import com.ilkun.delivery.entity.Order;
import com.ilkun.delivery.entity.Pizza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class SimpleOrderService {

    private static final List<Order> orders = new ArrayList<>();
    private static final Map<Integer, Pizza> pizzas = new HashMap<>();
    static {
        pizzas.put(1, new Pizza(1, "SEA", 4.0, Pizza.PizzaType.SEA));
        pizzas.put(2, new Pizza(2, "MEAT", 4.0, Pizza.PizzaType.MEAT));
        pizzas.put(3, new Pizza(3, "VEGETARIAN", 4.0, Pizza.PizzaType.VEGETARIAN));
    }
    
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {
        List<Pizza> pizzas = new ArrayList<>();

        for (Integer id : pizzasID) {
            pizzas.add(getPizzaByID(id));  // get Pizza from predifined in-memory list
        }
        Order newOrder = new Order(customer, pizzas);

        saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

    public Pizza getPizzaByID(Integer id) {
        return pizzas.get(id);
    }

    private void saveOrder(Order newOrder) {
        orders.add(newOrder);
    }
}
