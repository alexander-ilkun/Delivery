package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.PizzaRepository;

/**
 *
 * @author alexander-ilkun
 */
public class SimplePizzaService implements PizzaService {

    private final PizzaRepository pizzaRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    
    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    }
}
