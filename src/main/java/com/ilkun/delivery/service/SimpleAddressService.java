package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleAddressService implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public SimpleAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    
    @Override
    public Address find(Integer id) {
        return addressRepository.find(id);
    }
}
