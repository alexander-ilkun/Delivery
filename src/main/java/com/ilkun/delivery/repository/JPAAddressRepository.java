package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JPAAddressRepository implements AddressRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Address find(Long id) {
        return em.find(Address.class, id);
    }
    
    @Override
    public List<Address> findAll() {
        return em.createQuery("from Address", Address.class).getResultList();
    }

    @Override
    public Address save(Address address) {
        if (address.getId() == null) {
            em.persist(address);
        } else {
            em.merge(address);
        }
        return address;
    }
}
