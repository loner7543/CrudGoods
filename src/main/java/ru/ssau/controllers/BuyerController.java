package ru.ssau.controllers;

import model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.impl.BuyerRepositoryImpl;
import service.BuyerService;

import java.util.List;

@RestController
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllBuyers")
    public List<Buyer> getAllBuyerrs(){
        List<Buyer> buyers = buyerService.getAllI();
        return buyers;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateBuyer")
    public void updateBuyer(@RequestBody Buyer buyer){
        buyerService.updateBuyer(buyer);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBuyer")
    public void addBuyer(@RequestBody Buyer buyer){
            buyerService.addBuyer(buyer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteBuyer")
    public void deleteBuyer(@RequestParam(value = "id") Integer buyerId){
            Buyer deleted = buyerService.getBuyerById(buyerId);
            buyerService.removeBuyer(deleted);
    }

    //http://localhost:8080/crudGoods/index.html#/buyers
}
