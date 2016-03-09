package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import java.util.List;

/**
 *
 * @author alexander-ilkun
 */
public interface PizzaService {

    Pizza find(Long id);

    List<Pizza> findAll();
    
    Pizza save(Pizza pizza);
}
