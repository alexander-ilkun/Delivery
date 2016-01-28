package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Customer;

/**
 *
 * @author alexander-ilkun
 */
public interface CustomerRepository {
    
    Customer find(Integer id);
}
