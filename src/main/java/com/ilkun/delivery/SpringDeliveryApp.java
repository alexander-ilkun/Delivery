package com.ilkun.delivery;

import com.ilkun.delivery.repository.PizzaRepository;
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
        PizzaRepository pizzaRepo = (PizzaRepository) appContext.getBean("pizzaRepo");
        System.out.println(pizzaRepo.find(1));
    }

}
