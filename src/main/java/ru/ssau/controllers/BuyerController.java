package ru.ssau.controllers;

import model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.impl.BuyerRepositoryImpl;
import service.BuyerService;

import java.util.List;

@RestController(value = "buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAllBuyerrs() {
        List<Buyer> buyers = buyerService.getAllI();
        return buyers;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateBuyer(@RequestBody Buyer buyer) {
        buyerService.updateBuyer(buyer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBuyer(@RequestBody Buyer buyer) {
        buyerService.addBuyer(buyer);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteBuyer(@RequestParam(value = "id") Integer buyerId) {
        Buyer deleted = buyerService.getBuyerById(buyerId);
        buyerService.removeBuyer(deleted);
    }

    //http://localhost:8080/crudGoods/index.html#/buyers
}
