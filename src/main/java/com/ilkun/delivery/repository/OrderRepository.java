package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;

/**
 *
 * @author alexander-ilkun
 */
public interface OrderRepository {

    Order save(Order order);
}
