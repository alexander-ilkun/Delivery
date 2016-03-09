package com.ilkun.delivery.infrastructure;

import com.ilkun.delivery.domain.Pizza;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @author alexander-ilkun
 */
public class PizzaFactoryBean implements FactoryBean<Pizza> {

    private Long id;
    private String name;
    private Pizza.PizzaType type;
    private double price;
    
    @Override
    public Pizza getObject() throws Exception {
        return new Pizza(id, name, price, type);
    }

    @Override
    public Class<?> getObjectType() {
        return Pizza.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pizza.PizzaType getType() {
        return type;
    }

    public void setType(Pizza.PizzaType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
