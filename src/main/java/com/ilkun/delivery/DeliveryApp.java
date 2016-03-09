package com.ilkun.delivery;

import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.infrastructure.ApplicationContext;
import com.ilkun.delivery.infrastructure.JavaConfig;
import com.ilkun.delivery.infrastructure.JavaConfigApplicationContext;
import com.ilkun.delivery.service.UserService;
import com.ilkun.delivery.service.OrderService;

/**
 *
 * @author alexander-ilkun
 */
public class DeliveryApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());

        UserService customerService = (UserService) context.getBean("customerService");
        OrderService orderService = (OrderService) context.getBean("orderService");

        User customer = customerService.find(1L);
        Order order = orderService.placeNewOrder(customer, new Long[]{1l, 2l, 3l}, new Integer[]{1, 2, 3});

        System.out.println(order);
    }
}
