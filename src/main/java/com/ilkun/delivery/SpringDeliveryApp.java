package com.ilkun.delivery;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.service.CustomerService;
import com.ilkun.delivery.service.OrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alexander-ilkun
 */
public class SpringDeliveryApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext
                = new ClassPathXmlApplicationContext("appContext.xml");
        CustomerService customerService = appContext.getBean(CustomerService.class);
        OrderService orderService = appContext.getBean(OrderService.class);

        Customer customer = customerService.find(1);
        Order order = orderService.placeNewOrder(customer, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3});

        System.out.println(order);
        
        appContext.close();
    }

}
