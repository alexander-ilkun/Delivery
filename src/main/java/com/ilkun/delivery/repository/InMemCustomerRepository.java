package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Customer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class InMemCustomerRepository implements CustomerRepository {

    private static int curId = 1;
    private static final Map<Integer, Customer> customers = new HashMap<>();

    @PostConstruct
    public void init() {
        customers.put(curId, new Customer(curId++, "Dmytryi"));
        customers.put(curId, new Customer(curId++, "Vladislav"));
        customers.put(curId, new Customer(curId++, "Vitaliy"));        
    }
    
    @Override
    public Customer find(Integer id) {
        return customers.get(id);
    }
    
}
