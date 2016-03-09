package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.repository.BonusCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleBonusCardService implements BonusCardService {

    @Autowired
    private BonusCardRepository bonusCardRepository;

    @Override
    public BonusCard find(Long id) {
        return bonusCardRepository.find(id);
    }

    @Override
    public BonusCard save(BonusCard bonusCard) {
        return bonusCardRepository.save(bonusCard);
    }
}
