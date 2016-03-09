package com.ilkun.delivery.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexander-ilkun
 */
@Controller
@SessionAttributes("name")
public class HelloController {

    @ModelAttribute(value = "name")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String createHelloString() {
        return "hello";
    }
}
