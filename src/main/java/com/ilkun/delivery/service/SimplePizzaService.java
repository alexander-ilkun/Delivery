package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexander-ilkun
 */
@Service
public class SimplePizzaService implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    
    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    }
}
