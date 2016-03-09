package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleAddressService implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address find(Long id) {
        return addressRepository.find(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
