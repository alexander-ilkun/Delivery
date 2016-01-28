package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;

/**
 *
 * @author alexander-ilkun
 */
public interface OrderRepository {

    Order find(Integer id);
    
    Order save(Order order);
}
