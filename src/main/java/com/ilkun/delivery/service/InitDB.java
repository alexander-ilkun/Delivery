package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.domain.Role;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.repository.PizzaRepository;
import com.ilkun.delivery.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexander-ilkun
 */
public class InitDB {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PizzaRepository pizzaRepository;
    
    public void init() {
        Pizza pizza = new Pizza();
        pizzaRepository.save(pizza);
        
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        
        User userAdmin = new User();
        userAdmin.setName("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);
    }
}
