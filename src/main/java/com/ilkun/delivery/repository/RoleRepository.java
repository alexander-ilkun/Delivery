package com.ilkun.delivery.repository;

import com.ilkun.delivery.domain.Role;
import java.util.List;

/**
 *
 * @author alexander-ilkun
 */
public interface RoleRepository {
    
    Role find(Long id);

    List<Role> findAll();
    
    Role save(Role role);
    
    Role findByName(String name);
}
