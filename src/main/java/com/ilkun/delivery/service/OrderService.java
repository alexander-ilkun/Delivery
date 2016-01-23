package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;

/**
 *
 * @author alexander-ilkun
 */
public interface OrderService {

    Order placeNewOrder(Customer customer, Integer... pizzasID);
}
