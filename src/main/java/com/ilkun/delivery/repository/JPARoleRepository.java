package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JPARoleRepository implements RoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role find(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public List<Role> findAll() {
        return em.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role save(Role role) {
        if (role.getId() == null) {
            em.persist(role);
        } else {
            em.merge(role);
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        TypedQuery<Role> query = em.createQuery(
                "FROM Role AS role WHERE role.name=:name", Role.class);
        query.setParameter("name", name);
        List<Role> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }    
}
