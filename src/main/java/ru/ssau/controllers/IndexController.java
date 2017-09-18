package ru.ssau.controllers;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String slash(Model model, HttpSession session) {
        return "redirect:/welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public ModelAndView welcome(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("welcome");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public void testDb(){
        List<Product> products = productService.getAll();
        String s = "derfrf";
    }
}
