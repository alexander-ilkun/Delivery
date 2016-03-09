package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.User;
import java.util.List;

public interface UserRepository {
    
    User find(Long id);

    List<User> findAll();
    
    User save(User user);
    
    User findByName(String name);
}
