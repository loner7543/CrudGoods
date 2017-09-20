package ru.ssau.controllers;

import model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DiscountService;

import java.util.List;

@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @RequestMapping(method = RequestMethod.GET, value = "/getDiscounts")
    public @ResponseBody List<Discount> getAddDiscounts(){
        List<Discount> discounts = discountService.getAllDisc();
        return discounts;
    }
}
