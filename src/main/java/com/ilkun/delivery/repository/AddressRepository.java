package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Address;

/**
 *
 * @author alexander-ilkun
 */
public interface AddressRepository {
    
    Address find(Integer id);
}
