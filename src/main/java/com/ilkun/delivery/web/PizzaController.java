package com.ilkun.delivery.web;

import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.service.PizzaService;
import java.beans.PropertyEditorSupport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alexander-ilkun
 */
@Controller
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("pizzas", pizzaService.findAll());
        return "pizzas";
    }

    @RequestMapping(value = "/pizza", method = RequestMethod.GET)
    @ResponseBody
    public String viewPizzaById(@RequestParam("id") Long id, Model model) {
        return pizzaService.find(id).toString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "newpizza";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String add(@ModelAttribute Pizza pizza) {
        System.out.println(pizza);
        pizzaService.save(pizza);
        return "redirect:pizzas";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport() {
//
//            @Override
//            public void setAsText(String pizzaId) throws IllegalArgumentException {
//                Pizza pizza;
//                if (pizzaId == null || pizzaId.isEmpty()) {
//                    pizza = new Pizza();
//                } else {
//                    pizza = pizzaService.find(Long.valueOf(pizzaId));
//                }
//                setValue(pizza);
//            }
//        });
//    }
}
