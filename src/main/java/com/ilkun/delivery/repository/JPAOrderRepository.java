package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Order find(Long id) {
        return em.find(Order.class, id);
    }
    
    @Override
    public List<Order> findAll() {
        return em.createQuery("from Order", Order.class).getResultList();
    }

    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            em.persist(order);
        } else {
            em.merge(order);
        }
        return order;
    }

    @Override
    public List<Order> findOrdersByUser(User user) {
        TypedQuery<Order> query = em.createQuery(
                "from Order AS order WHERE order.user=:user", Order.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
}
