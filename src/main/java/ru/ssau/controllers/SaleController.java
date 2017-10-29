package ru.ssau.controllers;

import model.Sale;
import model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.SaleService;

import java.util.Date;
import java.util.List;

//todo replace all null's
@Controller
@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllSells")
    public  @ResponseBody List<Sale> getAllSells(){
        return saleService.getAllSells();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addSale")
    public ResponseEntity addSale(@RequestParam(value = Sale.ORDER_DATE_VALUE) Long orderDate,
                        @RequestParam(value = Sale.DELIVERY_DATE_VALUE) Long deliveryDate,
                        @RequestParam(value = Sale.AMOUNT_PRODUCT_VALUE) Integer amountProduct){
        Sale sale = new Sale(new Date(orderDate),new Date(deliveryDate),amountProduct,null,null);
        saleService.addSale(sale);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateSale")
    public ResponseEntity updateSale(@RequestParam(value = Sale.ID_VALUE) Integer saleId,
                           @RequestParam(value = Sale.ORDER_DATE_VALUE) Long orderDate,
                           @RequestParam(value = Sale.DELIVERY_DATE_VALUE) Long deliveryDate){
        Sale existingSale = saleService.getSaleById(saleId);
        saleService.updateSale(existingSale);// todo дописать
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteSale")
    public ResponseEntity deleteSale(@RequestParam(value = Sale.ID_VALUE) Integer saleId){
        Sale deletedSale = saleService.getSaleById(saleId);
        saleService.deleteSale(deletedSale);
        return new ResponseEntity(HttpStatus.OK);
    }

}
