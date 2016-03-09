package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.PizzaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimplePizzaService implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza find(Long id) {
        return pizzaRepository.find(id);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    @Transactional
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
}
