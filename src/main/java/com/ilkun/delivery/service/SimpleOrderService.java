package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.OrderRepository;
import com.ilkun.delivery.util.ServiceLocator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander-ilkun
 */
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    
    public SimpleOrderService() throws InstantiationException, IllegalAccessException {
        orderRepository = (OrderRepository) ServiceLocator.getInstance().createObject("orderRepository");
        pizzaService = (PizzaService) ServiceLocator.getInstance().createObject("pizzaService");
    }
    
    @Override
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {
        List<Pizza> pizzas = new ArrayList<>();

        for (Integer id : pizzasID) {
            pizzas.add(getPizzaByID(id));  // get Pizza from predifined in-memory list
        }
        Order newOrder = new Order(customer, pizzas);

        saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }
}
