package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.DiscountManager;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.OrderRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final DiscountManager discountManager;
    
    public SimpleOrderService(OrderRepository orderRepository,
            PizzaService pizzaService, DiscountManager discountManager) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.discountManager = discountManager;
    }

    @Override
    public Order placeNewOrder(Customer customer, Integer[] pizzasID,
            Integer[] pizzasNumber) {
        Map<Pizza, Integer> pizzas = new HashMap<>();
        Address address = customer.getAddresses().get(0); // TODO : choose correct address
        for (int i = 0; i < pizzasID.length; i++) {
            pizzas.put(getPizzaByID(pizzasID[i]), pizzasNumber[i]);
        }
        Order newOrder = new Order(customer, address, pizzas, discountManager);
        saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }
}
