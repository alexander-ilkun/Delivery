package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Pizza;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexander-ilkun
 */
@Repository
public class JPAPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    //@Transactional(readOnly = true)
    public Pizza find(Long id) {
        return em.find(Pizza.class, id);
    }
    
    @Override
    public List<Pizza> findAll() {
        return em.createQuery("from Pizza", Pizza.class).getResultList();
    }

    @Override
    //@Transactional
    public Pizza save(Pizza pizza) {
        if (pizza.getId() == null) {
            em.persist(pizza);
        } else {
            em.merge(pizza);
        }
        return pizza;
    }
}
