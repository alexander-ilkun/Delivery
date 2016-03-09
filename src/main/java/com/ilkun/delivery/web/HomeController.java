package com.ilkun.delivery.web;

import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.service.PizzaService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    PizzaService pizzaService;
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model, HttpSession session) {
        if (session.getAttribute("bucket") == null) {
            session.setAttribute("bucket", new Order());
        }
        model.addAttribute("pizzas", pizzaService.findAll());
        return "home";
    }
}
