package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Role;
import com.ilkun.delivery.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleRoleService implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public Role find(Long id) {
        return roleRepository.find(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
    
}
