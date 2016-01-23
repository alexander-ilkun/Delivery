package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.PizzaRepository;
import com.ilkun.delivery.util.ServiceLocator;

/**
 *
 * @author alexander-ilkun
 */
public class SimplePizzaService implements PizzaService {

    private final PizzaRepository pizzaRepository;

    public SimplePizzaService() throws InstantiationException, IllegalAccessException {
        pizzaRepository = (PizzaRepository) ServiceLocator.getInstance().createObject("pizzaRepository");
    }
    
    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    }
}
