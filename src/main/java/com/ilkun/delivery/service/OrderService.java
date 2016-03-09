package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.Order;

/**
 *
 * @author alexander-ilkun
 */
public interface OrderService {

    Order placeNewOrder(User customer, Long[] pizzasID, Integer[] pizzasNumber);

    Order addPizza(Order order, Long pizzaId, int quantity);

    Order removePizza(Order bucket, Long pizzaId);
}
