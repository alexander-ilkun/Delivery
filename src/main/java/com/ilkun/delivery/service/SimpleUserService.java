package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.domain.Role;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimpleUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private RoleService roleService;
    
    @Override
    public User find(Long id) {
        return userRepository.find(id);
    }
    
    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    @Override
    public User register(User user) {
        //user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_USER"));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User addAddress(User user, Address address) {
        addressService.save(address);
        user.getAddresses().add(address);
        return userRepository.save(user);
    }
}
