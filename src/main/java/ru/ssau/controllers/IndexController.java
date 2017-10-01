package ru.ssau.controllers;

import model.Discount;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.DiscountService;
import service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class IndexController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String slash(Model model, HttpSession session) {
        return "redirect:/welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public ModelAndView welcome(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("welcome");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
