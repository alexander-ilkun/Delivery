package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.User;

/**
 *
 * @author alexander-ilkun
 */
public interface UserService {
    
    User find(Long id);

    User findByName(String name);

    User register(User user);

    User addAddress(User user, Address address);
}
