package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.User;
import java.util.List;

public interface OrderRepository {

    Order find(Long id);
    
    List<Order> findAll();
    
    Order save(Order order);

    List<Order> findOrdersByUser(User user);
}
