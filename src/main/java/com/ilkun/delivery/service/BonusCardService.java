package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.BonusCard;

/**
 *
 * @author alexander-ilkun
 */
public interface BonusCardService {
    
    BonusCard find(Integer id);

    BonusCard withdraw(BonusCard bonusCard, double withdrawAmount);

    BonusCard deposit(BonusCard bonusCard, double depositAmount);
}
