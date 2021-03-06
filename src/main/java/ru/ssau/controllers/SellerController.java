package ru.ssau.controllers;

import model.Sale;
import model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.SaleService;
import service.SellerService;

import java.util.Date;
import java.util.List;

@RestController
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SaleService saleService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllSellers")//+
    public @ResponseBody List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addSeller")
    public ResponseEntity addSeller(@RequestParam(value = Seller.FIRST_NAME_VALUE) String firstName,
                          @RequestParam(value = Seller.MIDDLE_NAME_VALUE) String middleName,
                          @RequestParam(value = Seller.LAST_NAME_VALUE) String lastName,
                          @RequestParam(value = Seller.BIRTH_DATE_VALUE) Long birthDate,
                          @RequestParam(value = Seller.EMAIL_VALUE) String email,
                          @RequestParam(value = Seller.DELIVERY_ADDRESS_VALUE) String deliveryAddress,
                                    @RequestParam(value = Seller.SALE_ID) Integer saleId){
        try{
            Sale sale = saleService.getSaleById(saleId);
            Seller seller = new Seller(firstName,middleName,lastName,new Date(birthDate),email,deliveryAddress,sale);
            sellerService.addSeller(seller);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateSeller")
    public ResponseEntity updateSeller(@RequestParam(value = Seller.ID_VALUE) Integer id,
                             @RequestParam(value = Seller.FIRST_NAME_VALUE) String firstName,
                             @RequestParam(value = Seller.MIDDLE_NAME_VALUE) String middleName,
                             @RequestParam(value = Seller.LAST_NAME_VALUE) String lastName,
                             @RequestParam(value = Seller.BIRTH_DATE_VALUE) Long birthDate,
                             @RequestParam(value = Seller.EMAIL_VALUE) String email,
                             @RequestParam(value = Seller.DELIVERY_ADDRESS_VALUE) String deliveryAddress,
                                       @RequestParam(value = Seller.SALE_ID) Integer saleId){
        try{
            Seller updatedSeller = sellerService.getSellerById(id);
            Sale selectedSale = saleService.getSaleById(saleId);
            updatedSeller.setFirstName(firstName);
            updatedSeller.setLastName(lastName);
            updatedSeller.setMiddleName(middleName);
            updatedSeller.setBirthDate(new Date(birthDate));
            updatedSeller.setEmail(email);
            updatedSeller.setDeliveryAddress(deliveryAddress);
            updatedSeller.setSale(selectedSale);
            sellerService.updateSeller(updatedSeller);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteSeller")
    public ResponseEntity deleteSeller(@RequestParam(value = Seller.ID_VALUE) Integer sellerId){
        try{
            Seller deleted = sellerService.getSellerById(sellerId);
            sellerService.deleteSeller(deleted);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
