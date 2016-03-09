package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;

public interface AddressService {
    
    Address find(Long id);

    Address save(Address address);
}
