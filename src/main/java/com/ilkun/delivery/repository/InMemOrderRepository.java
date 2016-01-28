package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class InMemOrderRepository implements OrderRepository {

    private static int curId = 1;
    private static final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order find(Integer id) {
        return orders.get(id);
    }
    
    @Override
    public Order save(Order order) {
        order.setId(curId);
        orders.put(curId++, order);
        return order;
    }
}
