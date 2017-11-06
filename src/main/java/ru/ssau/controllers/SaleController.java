package ru.ssau.controllers;

import model.Buyer;
import model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BuyerService;
import service.SaleService;

import java.util.Date;
import java.util.List;

//todo replace all null's
@Controller
@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.POST, value = "/getAllSells")
    public  @ResponseBody List<Sale> getAllSells(){
        return saleService.getAllSells();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addSale")
    public ResponseEntity<Throwable> addSale(@RequestParam(value = Sale.ORDER_DATE_VALUE) Long orderDate,
                                             @RequestParam(value = Sale.DELIVERY_DATE_VALUE) Long deliveryDate,
                                             @RequestParam(value = Sale.AMOUNT_PRODUCT_VALUE) Integer amountProduct,
                                             @RequestParam(value = Sale.SELECTED_BUYER_ID) Integer buyerId) {
        Buyer selectedBuyer = buyerService.getBuyerById(buyerId);
        Sale sale = new Sale(new Date(orderDate),new Date(deliveryDate),amountProduct,null,selectedBuyer);
        try {
            saleService.addSale(sale);
        }
        catch (Throwable e){
         return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

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

    @RequestMapping(method = RequestMethod.POST, value = "/deleteSale")
    public ResponseEntity deleteSale(@RequestParam(value = Sale.ID_VALUE) Integer saleId){
        try{
            Sale deletedSale = saleService.getSaleById(saleId);
            saleService.deleteSale(deletedSale);
        }
        catch (Throwable ex){
            return new ResponseEntity(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
