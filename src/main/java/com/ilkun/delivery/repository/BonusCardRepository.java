package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.BonusCard;
import java.util.List;

public interface BonusCardRepository {
    
    BonusCard find(Long id);

    List<BonusCard> findAll();
    
    BonusCard save(BonusCard bonusCard);
}
