package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.Order;
import java.util.List;

public interface OrderService {

    Order create();
    
    Order addPizza(Order order, Long pizzaId, int quantity);

    Order removePizza(Order order, Long pizzaId);

    Order checkout(Order order, User user);

    Order place(Order order, Address address);

    Order save(Order order);

    List<Order> findOrdersByUser(User user);
}
