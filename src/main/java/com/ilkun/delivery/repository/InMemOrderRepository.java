package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander-ilkun
 */
public class InMemOrderRepository implements OrderRepository {

    private static final List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }
}
