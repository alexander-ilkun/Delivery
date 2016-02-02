package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Address;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class InMemAddressRepository implements AddressRepository {

    private static int curId = 1;
    private static final Map<Integer, Address> addresses = new HashMap<>();

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
    public Address find(Integer id) {
        return addresses.get(id);
    }
    
}
