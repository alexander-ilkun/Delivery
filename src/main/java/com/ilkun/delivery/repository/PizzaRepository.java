package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Pizza;
import java.util.List;

/**
 *
 * @author alexander-ilkun
 */
public interface PizzaRepository {

    Pizza find(Long id);

    List<Pizza> findAll();
    
    Pizza save(Pizza pizza);
}
