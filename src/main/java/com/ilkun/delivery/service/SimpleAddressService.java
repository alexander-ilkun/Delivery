package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.repository.AddressRepository;


public class SimpleAddressService implements AddressService {

    private final AddressRepository addressRepository;

    public SimpleAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    
    @Override
    public Address find(Integer id) {
        return addressRepository.find(id);
    }
}
