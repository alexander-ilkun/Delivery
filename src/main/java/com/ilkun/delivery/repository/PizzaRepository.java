package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Pizza;

/**
 *
 * @author alexander-ilkun
 */
public interface PizzaRepository {

    Pizza find(Integer id);
}
