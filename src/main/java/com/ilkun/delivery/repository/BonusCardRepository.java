package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.BonusCard;

/**
 *
 * @author alexander-ilkun
 */
public interface BonusCardRepository {
    
    BonusCard find(Integer id);

    BonusCard save(BonusCard bonusCard);
}
