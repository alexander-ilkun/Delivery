package com.ilkun.delivery.domain.discount;

import com.ilkun.delivery.domain.Order;

public interface DiscountManager {
    
    double getDiscount(Order order);
}
