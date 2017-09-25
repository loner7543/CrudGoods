package ru.ssau.controllers;

import model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.SellerService;

import java.util.List;

// todo replace all null's
@RestController
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllSellers")
    public @ResponseBody List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addSeller")
    public void addSeller(){
        sellerService.addSeller(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateSeller")
    public void updateSeller(){
        sellerService.updateSeller(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteSeller")
    public void deleteSeller(){
        sellerService.deleteSeller(null);
    }
}
