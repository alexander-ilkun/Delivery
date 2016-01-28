package com.ilkun.delivery;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.infrastructure.ApplicationContext;
import com.ilkun.delivery.infrastructure.JavaConfig;
import com.ilkun.delivery.infrastructure.JavaConfigApplicationContext;
import com.ilkun.delivery.service.CustomerService;
import com.ilkun.delivery.service.OrderService;

/**
 *
 * @author alexander-ilkun
 */
public class DeliveryApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());

        CustomerService customerService = (CustomerService) context.getBean("customerService");
        OrderService orderService = (OrderService) context.getBean("orderService");

        Customer customer = customerService.find(1);
        Order order = orderService.placeNewOrder(customer, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3});

        System.out.println(order);
    }
}
