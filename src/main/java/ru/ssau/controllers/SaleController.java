package ru.ssau.controllers;

import model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.SaleService;

import java.util.List;

//todo replace all null's
@Controller
@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllSells")
    public List<Sale> getAllSells(){
        return saleService.getAllSells();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addSale")
    public void addSale(){
        saleService.addSale(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateSale")
    public void updateSale(){
        saleService.updateSale(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteSale")
    public void deleteSale(){
        saleService.deleteSale(null);
    }

}
