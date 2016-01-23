package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.InMemPizzaRepository;
import com.ilkun.delivery.repository.PizzaRepository;

/**
 *
 * @author alexander-ilkun
 */
public class SimplePizzaService implements PizzaService {

    private static final PizzaRepository pizzaRepository = new InMemPizzaRepository();

    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    }
}
