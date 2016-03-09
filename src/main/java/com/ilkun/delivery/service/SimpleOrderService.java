package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.DiscountManager;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.event.MessageEvent;
import com.ilkun.delivery.infrastructure.annotations.Benchmark;
import com.ilkun.delivery.repository.OrderRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexander-ilkun
 */
@Service
public class SimpleOrderService implements OrderService, ApplicationContextAware {

    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final DiscountManager discountManager;
    private ApplicationContext appContext;
    
    @Autowired
    public SimpleOrderService(OrderRepository orderRepository,
            PizzaService pizzaService, DiscountManager discountManager) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.discountManager = discountManager;
    }

    @Benchmark
    @Override
    public Order placeNewOrder(User customer, Long[] pizzasID,
            Integer[] pizzasNumber) {
        Map<Pizza, Integer> pizzas = new HashMap<>();
        Address address = customer.getAddresses().get(0); // TODO : choose correct address
        for (int i = 0; i < pizzasID.length; i++) {
            pizzas.put(getPizzaByID(pizzasID[i]), pizzasNumber[i]);
        }
        Order newOrder = new Order(customer, address, pizzas, discountManager);
        saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        appContext.publishEvent(new MessageEvent(this, "event from PlaceNewOrder"));
        return newOrder;
    }

    @Override
    public Order addPizza(Order order, Long pizzaId, int quantity) {
        order.addPizza(pizzaService.find(pizzaId), quantity);
        return order;
    }
    
    @Override
    public Order removePizza(Order order, Long pizzaId) {
        order.removePizza(pizzaService.find(pizzaId));
        return order;
    }
    
    @Benchmark
    private Pizza getPizzaByID(Long id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = appContext;
    }
}
