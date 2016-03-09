package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.repository.BonusCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleBonusCardService implements BonusCardService {

    private final BonusCardRepository bonusCardRepository;

    @Autowired
    public SimpleBonusCardService(BonusCardRepository bonusCardRepository) {
        this.bonusCardRepository = bonusCardRepository;
    }
    
    @Override
    public BonusCard find(Long id) {
        return bonusCardRepository.find(id);
    }

    @Override
    public BonusCard withdraw(BonusCard bonusCard, double withdrawAmount) {
        bonusCard.withdraw(withdrawAmount);
        return bonusCardRepository.save(bonusCard);
    }

    @Override
    public BonusCard deposit(BonusCard bonusCard, double depositAmount) {
        bonusCard.deposit(depositAmount);
        return bonusCardRepository.save(bonusCard);
    }
    
}
