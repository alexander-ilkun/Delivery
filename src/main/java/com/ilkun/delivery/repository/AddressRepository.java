package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Address;
import java.util.List;

public interface AddressRepository {
    
    Address find(Long id);

    List<Address> findAll();

    Address save(Address address);
}
