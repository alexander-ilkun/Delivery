package com.ilkun.delivery.web;

import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.service.OrderService;
import com.ilkun.delivery.service.PizzaService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexander-ilkun
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    
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
}
