package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Role;

public interface RoleService {
    
    Role find(Long id);

    Role findByName(String name);
}
