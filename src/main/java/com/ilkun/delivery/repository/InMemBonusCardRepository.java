package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.repository.BonusCardRepository;
import com.ilkun.delivery.repository.BonusCardRepository;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class InMemBonusCardRepository implements BonusCardRepository {

    private static long curId = 1;
    private static final Map<Long, BonusCard> bonusCards = new HashMap<>();

    @PostConstruct
    public void init() {
        bonusCards.put(curId, new BonusCard(curId++, 10.0));
    }
    
    @Override
    public BonusCard find(Long id) {
        return bonusCards.get(id);
    }

    @Override
    public BonusCard save(BonusCard bonusCard) {
        return bonusCard;
    }
}
