package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JPAUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User find(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        return user;
    }

    @Override
    public User findByName(String name) {
        TypedQuery<User> query = em.createQuery(
                "FROM User AS user WHERE user.name=:name", User.class);
        query.setParameter("name", name);
        List<User> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
