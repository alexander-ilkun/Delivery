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

    private final UserRepository userRepository;
    private final AddressService addressService;
    private final BonusCardService bonusCardService;
    private final RoleService roleService;
    
    @Autowired
    public SimpleUserService(UserRepository customerRepository,
            AddressService addressService, BonusCardService bonusCardService, RoleService roleService) {
        this.userRepository = customerRepository;
        this.addressService = addressService;
        this.bonusCardService = bonusCardService;
        this.roleService = roleService;
    }
    
    @Override
    public User find(Long id) {
        User user = userRepository.find(id);
        List<Address> addresses = getAddressesByCustomer(user);
        BonusCard bonusCard = getBonusCardByCostumer(user);
        user.setAddresses(addresses);
        user.setBonusCard(bonusCard);
        return user;
    }
    
    private List<Address> getAddressesByCustomer(User customer) {
        List<Address> addresses = new ArrayList<>();        
        // TODO : find correct addresses
        addresses.add(addressService.find(1L));
        addresses.add(addressService.find(2L));
        return addresses;
    }

    private BonusCard getBonusCardByCostumer(User customer) {
        // TODO : find correct bonusCards
        return bonusCardService.find(1L);
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
