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
        ConfigurableApplicationContext repositoryContext
                = new ClassPathXmlApplicationContext(
                    "repositoryContext.xml");
        ConfigurableApplicationContext appContext
                = new ClassPathXmlApplicationContext(new String[]{
                    "appContext.xml"},
                    repositoryContext);
        CustomerService customerService = (CustomerService) appContext.getBean("customerService");
        OrderService orderService = (OrderService) appContext.getBean("orderService");

        Customer customer = customerService.find(1);
        Order order = orderService.placeNewOrder(customer, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3});

        System.out.println(order);
        
        appContext.close();
        repositoryContext.close();
    }

}
