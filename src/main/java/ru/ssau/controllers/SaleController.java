package ru.ssau.controllers;

import model.Buyer;
import model.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.impl.BuyerRepositoryImpl;
import repository.impl.SaleRepositoryImpl;
import service.SaleService;
import service.SellerService;

import java.util.Date;
import java.util.List;

@RestController(value = "sale")
public class SaleController {
    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private SaleService saleService;

    @Autowired
    private BuyerRepositoryImpl buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sale> getAllSells() {
        return saleService.getAllSells();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSale(@RequestBody Sale sale) {
        logger.info("started");
        Buyer selectedBuyer = buyerService.getBuyerById(sale.getBuyer().getId());
        sale.setBuyer(selectedBuyer);
        saleService.addSale(sale);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateSale(@RequestBody Sale sale) {
        saleService.updateSale(sale);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSale(@RequestParam(value = "id") Integer saleId) {
        saleService.deleteSale(saleId);
    }

}
