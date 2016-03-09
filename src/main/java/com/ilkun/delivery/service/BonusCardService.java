package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.BonusCard;

public interface BonusCardService {
    
    BonusCard find(Long id);

    BonusCard save(BonusCard bonusCard);
}
