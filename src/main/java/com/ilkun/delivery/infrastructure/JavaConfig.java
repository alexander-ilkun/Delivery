package com.ilkun.delivery.infrastructure;

import com.ilkun.delivery.repository.InMemOrderRepository;
import com.ilkun.delivery.repository.InMemPizzaRepository;
import com.ilkun.delivery.service.SimpleOrderService;
import com.ilkun.delivery.service.SimplePizzaService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class JavaConfig implements Config {

    private final Map<String, Class<?>> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
        ifc2Class.put("orderRepository", InMemOrderRepository.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
    }

    @Override
    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
