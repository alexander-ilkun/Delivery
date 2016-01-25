package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Pizza;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class InMemPizzaRepository implements PizzaRepository {

    private static final Map<Integer, Pizza> pizzas = new HashMap<>();

    public void init() {
        pizzas.put(1, new Pizza(1, "SEA", 4.0, Pizza.PizzaType.SEA));
        pizzas.put(2, new Pizza(2, "MEAT", 4.0, Pizza.PizzaType.MEAT));
        pizzas.put(3, new Pizza(3, "VEGETARIAN", 4.0, Pizza.PizzaType.VEGETARIAN));        
    }
    
    @Override
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
}
