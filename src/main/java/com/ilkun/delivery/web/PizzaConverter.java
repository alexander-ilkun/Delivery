package com.ilkun.delivery.web;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author alexander-ilkun
 */
public class PizzaConverter implements Converter<String, Pizza> {

    @Autowired
    private PizzaService pizzaService;
    
    @Override
    public Pizza convert(String pizzaId) {
        Pizza pizza;
        if (pizzaId == null || pizzaId.isEmpty()) {
            pizza = new Pizza();
        } else {
            Long id = Long.valueOf(pizzaId);
            if (id <= 0) {
                throw new IllegalArgumentException();
            }
            pizza = pizzaService.find(id);
        }
        return pizza;
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public String error(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
