package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;
    private final BonusCardService bonusCardService;
    
    @Autowired
    public SimpleCustomerService(CustomerRepository customerRepository,
            AddressService addressService, BonusCardService bonusCardService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
        this.bonusCardService = bonusCardService;
    }
    
    @Override
    public Customer find(Integer id) {
        Customer customer = customerRepository.find(id);
        List<Address> addresses = getAddressesByCustomer(customer);
        BonusCard bonusCard = getBonusCardByCostumer(customer);
        customer.setAddresses(addresses);
        customer.setBonusCard(bonusCard);
        return customer;
    }
    
    private List<Address> getAddressesByCustomer(Customer customer) {
        List<Address> addresses = new ArrayList<>();        
        // TODO : find correct addresses
        addresses.add(addressService.find(1));
        addresses.add(addressService.find(2));
        return addresses;
    }

    private BonusCard getBonusCardByCostumer(Customer customer) {
        // TODO : find correct bonusCards
        return bonusCardService.find(1);
    }
}
