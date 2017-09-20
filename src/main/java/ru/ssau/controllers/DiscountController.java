package ru.ssau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.DiscountService;

@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;


}
