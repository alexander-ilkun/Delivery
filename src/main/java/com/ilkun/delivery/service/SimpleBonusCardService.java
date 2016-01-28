package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.repository.BonusCardRepository;


public class SimpleBonusCardService implements BonusCardService {

    private final BonusCardRepository bonusCardRepository;

    public SimpleBonusCardService(BonusCardRepository bonusCardRepository) {
        this.bonusCardRepository = bonusCardRepository;
    }
    
    @Override
    public BonusCard find(Integer id) {
        return bonusCardRepository.find(id);
    }

    @Override
    public BonusCard withdraw(BonusCard bonusCard, double withdrawAmount) {
        bonusCard.setAmount(bonusCard.getAmount() - withdrawAmount);
        return bonusCardRepository.save(bonusCard);
    }

    @Override
    public BonusCard deposit(BonusCard bonusCard, double depositAmount) {
        bonusCard.setAmount(bonusCard.getAmount() + depositAmount);
        return bonusCardRepository.save(bonusCard);
    }
    
}
