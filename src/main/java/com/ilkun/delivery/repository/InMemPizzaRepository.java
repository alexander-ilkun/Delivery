package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.infrastructure.annotations.Benchmark;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class InMemPizzaRepository implements PizzaRepository {

    private static int curId = 1;
    private static final Map<Integer, Pizza> pizzas = new HashMap<>();

    public void init() {
        pizzas.put(curId, new Pizza(curId++, "SEA", 4.0, Pizza.PizzaType.SEA));
        pizzas.put(curId, new Pizza(curId++, "MEAT", 4.0, Pizza.PizzaType.MEAT));
        pizzas.put(curId, new Pizza(curId++, "VEGETARIAN", 4.0, Pizza.PizzaType.VEGETARIAN));        
    }
    
    @Benchmark
    @Override
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
}
