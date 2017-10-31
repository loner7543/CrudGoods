package ru.ssau.controllers;

import model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.SellerService;

import java.util.Date;
import java.util.List;

// todo replace all null's
@RestController
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.POST, value = "/getAllSellers")
    public @ResponseBody List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addSeller")
    public ResponseEntity addSeller(@RequestParam(value = Seller.FIRST_NAME_VALUE) String firstName,
                          @RequestParam(value = Seller.MIDDLE_NAME_VALUE) String middleName,
                          @RequestParam(value = Seller.LAST_NAME_VALUE) String lastName,
                          @RequestParam(value = Seller.BIRTH_DATE_VALUE) Long birthDate,
                          @RequestParam(value = Seller.EMAIL_VALUE) String email,
                          @RequestParam(value = Seller.EMAIL_VALUE) String deliveryAddress){
        Seller seller = new Seller(firstName,middleName,lastName,new Date(birthDate),email,deliveryAddress,null);
        sellerService.addSeller(seller);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateSeller")
    public ResponseEntity updateSeller(@RequestParam(value = Seller.ID_VALUE) Integer id,
                             @RequestParam(value = Seller.FIRST_NAME_VALUE) String firstName,
                             @RequestParam(value = Seller.MIDDLE_NAME_VALUE) String middleName,
                             @RequestParam(value = Seller.LAST_NAME_VALUE) String lastName,
                             @RequestParam(value = Seller.BIRTH_DATE_VALUE) Long birthDate,
                             @RequestParam(value = Seller.EMAIL_VALUE) String email,
                             @RequestParam(value = Seller.EMAIL_VALUE) String deliveryAddress){
        Seller updatedSeller = sellerService.getSellerById(id);
        updatedSeller.setFirstName(firstName);
        updatedSeller.setLastName(lastName);
        updatedSeller.setMiddleName(middleName);
        updatedSeller.setBirthDate(new Date(birthDate));
        updatedSeller.setEmail(email);
        updatedSeller.setDeliveryAddress(deliveryAddress);
        sellerService.updateSeller(updatedSeller);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteSeller")
    public ResponseEntity deleteSeller(@RequestParam(value = Seller.ID_VALUE) Integer sellerId){
        Seller deleted = sellerService.getSellerById(sellerId);
        sellerService.deleteSeller(deleted);
        return new ResponseEntity(HttpStatus.OK);
    }
}
