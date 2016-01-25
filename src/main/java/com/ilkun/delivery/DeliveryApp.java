package com.ilkun.delivery;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.infrastructure.ApplicationContext;
import com.ilkun.delivery.infrastructure.JavaConfig;
import com.ilkun.delivery.infrastructure.JavaConfigApplicationContext;
import com.ilkun.delivery.service.OrderService;

/**
 *
 * @author alexander-ilkun
 */
public class DeliveryApp {

    public static void main(String[] args) throws Exception {
        Customer customer = null;

        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());

        OrderService orderService = (OrderService) context.getBean("orderService");
        Order order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);

    }
}
