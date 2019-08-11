package ru.ssau.controllers;

import model.Sale;
import model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.impl.SaleRepositoryImpl;
import repository.impl.SellerRepositoryImpl;
import service.SellerService;

import java.util.Date;
import java.util.List;

@RestController(value = "seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SaleRepositoryImpl saleService;

    @RequestMapping(method = RequestMethod.GET)//+
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody Seller seller) {
        Sale sale = saleService.getSaleById(seller.getSale().getId());
        seller.setSale(sale);
        sellerService.addSeller(seller);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateSeller(@RequestBody Seller seller) {
        sellerService.updateSeller(seller);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSeller(@RequestParam(value = "id") Integer sellerId) {
//        Seller deleted = sellerService.getSellerById(sellerId);
        sellerService.deleteSeller(sellerId);
    }
}
