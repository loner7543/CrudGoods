package ru.ssau.controllers;

import model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BuyerService;

import java.util.List;

@Controller
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET, value = "/gab")
    public void getAllBuyerrs(){
        List<Buyer> buyers = buyerService.getAll();
        String s = "";

    }
}
