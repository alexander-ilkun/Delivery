package com.ilkun.delivery.web;

import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.service.AddressService;
import com.ilkun.delivery.service.OrderService;
import com.ilkun.delivery.service.UserService;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addPizza(HttpSession session, @RequestParam("pizzaId") Long pizzaId, @RequestParam int quantity) {
        Order bucket = (Order) session.getAttribute("bucket");
        orderService.addPizza(bucket, pizzaId, quantity);
        return "redirect:/";
    }

    @RequestMapping(value = "/order/remove", method = RequestMethod.POST)
    public String removePizza(HttpSession session, @RequestParam("pizzaId") Long pizzaId) {
        Order bucket = (Order) session.getAttribute("bucket");
        orderService.removePizza(bucket, pizzaId);
        return "redirect:/";
    }

    @RequestMapping(value = "/order/checkout", method = RequestMethod.GET)
    public String showCheckout(Model model, HttpSession session, Principal principal) {
        Order bucket = (Order) session.getAttribute("bucket");
        User user = userService.findByName(principal.getName());
        orderService.checkout(bucket, user);
        model.addAttribute("user", user);
        return "checkout";
    }

    @RequestMapping(value = "/order/checkout", method = RequestMethod.POST)
    public String confirmCheckout(HttpSession session, Principal principal,
            @RequestParam("addressId") Long addressId) {
        Order bucket = (Order) session.getAttribute("bucket");
        orderService.place(bucket, addressService.find(addressId));
        session.removeAttribute("bucket");
        return "redirect:/";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrdersByUser(Model model, Principal principal) {
        User user = userService.findByName(principal.getName());
        model.addAttribute("orders", orderService.findOrdersByUser(user));
        return "orders";
    }
}
