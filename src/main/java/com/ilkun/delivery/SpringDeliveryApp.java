package com.ilkun.delivery;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.Pizza;
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
        CustomerService customerService = appContext.getBean(CustomerService.class);
        OrderService orderService = appContext.getBean(OrderService.class);

        Customer customer = customerService.find(1);
        Order order = orderService.placeNewOrder(customer, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3});

        System.out.println(order);
        
//        for (String str : appContext.getBeanDefinitionNames()) {
//            System.out.println(str);
//        }
//        for (String str : repositoryContext.getBeanDefinitionNames()) {
//            System.out.println(str);
//        }
        
        Pizza pizza = (Pizza) appContext.getBean("pizzaFactoryBean");
        System.out.println(pizza);
        
        appContext.close();
        repositoryContext.close();
    }

}
