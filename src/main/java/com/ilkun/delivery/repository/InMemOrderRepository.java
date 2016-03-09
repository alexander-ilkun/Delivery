package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.repository.OrderRepository;
import com.ilkun.delivery.repository.OrderRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexander-ilkun
 */
@Repository
public class InMemOrderRepository implements OrderRepository {

    private static Long curId = 1l;
    private static final Map<Long, Order> orders = new HashMap<>();

    @Override
    public Order find(Long id) {
        return orders.get(id);
    }
    
    @Override
    public Order save(Order order) {
        order.setId(curId);
        orders.put(curId++, order);
        return order;
    }
}
