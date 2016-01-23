package com.ilkun.delivery;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.service.SimpleOrderService;

/**
 *
 * @author alexander-ilkun
 */
public class DeliveryApp {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Customer customer = null;
        Order order;

        SimpleOrderService orderService = new SimpleOrderService();
        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);
    }
}
