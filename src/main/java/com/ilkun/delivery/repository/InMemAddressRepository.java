package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.repository.AddressRepository;
import com.ilkun.delivery.repository.AddressRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

public class InMemAddressRepository implements AddressRepository {

    private static long curId = 1;
    private static final Map<Long, Address> addresses = new HashMap<>();

    @PostConstruct
    public void init() {
        addresses.put(curId, new Address(curId++, "3443", "Kyiv",
                "Pechersk", "Pecherska", "1"));
        addresses.put(curId, new Address(curId++, "4334", "Kyiv",
                "Holosiivsky", "Holosiivska", "1"));
        addresses.put(curId, new Address(curId++, "3434", "Kyiv",
                "Obolon", "Obolonska", "1"));        
    }
    
    @Override
    public Address find(Long id) {
        return addresses.get(id);
    }

    @Override
    public List<Address> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address save(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
