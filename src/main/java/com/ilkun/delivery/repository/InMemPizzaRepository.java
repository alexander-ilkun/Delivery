package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.infrastructure.annotations.Benchmark;
import com.ilkun.delivery.repository.PizzaRepository;
import com.ilkun.delivery.repository.PizzaRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexander-ilkun
 */
public class InMemPizzaRepository implements PizzaRepository {

    private static long curId = 1;
    private Map<Long, Pizza> pizzas = new HashMap<>();

    @PostConstruct
    public void init() {
        System.out.println("init() inMemPizzaRepository");
        pizzas.put(curId, new Pizza(curId++, "SEA", 4.0, Pizza.PizzaType.SEA));
        pizzas.put(curId, new Pizza(curId++, "MEAT", 4.0, Pizza.PizzaType.MEAT));
        pizzas.put(curId, new Pizza(curId++, "VEGETARIAN", 4.0, Pizza.PizzaType.VEGETARIAN));        
    }
    
    @Override
    @Benchmark
    public Pizza find(Long id) {
        return pizzas.get(id);
    }

    public Map<Long, Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Long, Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public Pizza save(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pizza> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
