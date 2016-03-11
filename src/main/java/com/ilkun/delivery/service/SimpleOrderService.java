package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.discount.DiscountManager;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimpleOrderService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private DiscountManager discountManager;
    @Autowired
    private BonusCardService bonusCardService;
    
    @Override
    public Order create() {
        return new Order();
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

    @Override
    public Order checkout(Order order, User user) {
        order.setUser(user);
        order.checkout(discountManager);
        return order;
    }
    
    @Transactional
    @Override
    public Order place(Order order, Address address) {
        bonusCardService.save(order.getUser().getBonusCard());
        order.setAddress(address);
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findOrdersByUser(User user) {
        return orderRepository.findOrdersByUser(user);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
