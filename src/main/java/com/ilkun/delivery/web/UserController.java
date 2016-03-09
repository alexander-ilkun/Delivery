package com.ilkun.delivery.web;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/personalinfo", method = RequestMethod.GET)
    public String showPersonalInfo(Model model, Principal principal) {
        model.addAttribute("user", userService.findByName(principal.getName()));
        return "personalinfo";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute User user) {
        userService.register(user);
        return "login";
    }

    @RequestMapping(value = "/address/add", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute Address address, Principal principal) {
        User user = userService.findByName(principal.getName());
        userService.addAddress(user, address);
        return "redirect:/app/personalinfo";
    }
}
