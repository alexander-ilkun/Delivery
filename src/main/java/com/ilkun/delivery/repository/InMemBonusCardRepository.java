package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.BonusCard;
import java.util.HashMap;
import java.util.Map;


public class InMemBonusCardRepository implements BonusCardRepository {

    private static int curId = 1;
    private static final Map<Integer, BonusCard> bonusCards = new HashMap<>();

    public void init() {
        bonusCards.put(curId, new BonusCard(curId++, 10.0));
    }
    
    @Override
    public BonusCard find(Integer id) {
        return bonusCards.get(id);
    }

    @Override
    public BonusCard save(BonusCard bonusCard) {
        return bonusCard;
    }
}
