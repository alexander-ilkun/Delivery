package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.BonusCard;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JPABonusCardRepository implements BonusCardRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public BonusCard find(Long id) {
        return em.find(BonusCard.class, id);
    }
    
    @Override
    public List<BonusCard> findAll() {
        return em.createQuery("from BonusCard", BonusCard.class).getResultList();
    }

    @Override
    public BonusCard save(BonusCard bonusCard) {
        if (bonusCard.getId() == null) {
            em.persist(bonusCard);
        } else {
            em.merge(bonusCard);
        }
        return bonusCard;
    }
}
