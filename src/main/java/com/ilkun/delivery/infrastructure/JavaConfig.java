package com.ilkun.delivery.infrastructure;

//import com.ilkun.delivery.service.repository.InMemAddressRepository;
//import com.ilkun.delivery.service.repository.InMemBonusCardRepository;
//import com.ilkun.delivery.service.repository.InMemCustomerRepository;
//import com.ilkun.delivery.service.repository.InMemOrderRepository;
//import com.ilkun.delivery.service.repository.InMemPizzaRepository;
import com.ilkun.delivery.service.SimpleAddressService;
import com.ilkun.delivery.service.SimpleBonusCardService;
import com.ilkun.delivery.service.SimpleUserService;
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
//        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
//        ifc2Class.put("orderRepository", InMemOrderRepository.class);
//        ifc2Class.put("addressRepository", InMemAddressRepository.class);
//        ifc2Class.put("customerRepository", InMemCustomerRepository.class);
//        ifc2Class.put("bonusCardRepository", InMemBonusCardRepository.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
        ifc2Class.put("addressService", SimpleAddressService.class);
        ifc2Class.put("customerService", SimpleUserService.class);
        ifc2Class.put("bonusCardService", SimpleBonusCardService.class);
    }

    @Override
    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
