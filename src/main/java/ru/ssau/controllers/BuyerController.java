package ru.ssau.controllers;

import model.Buyer;
import model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BuyerService;

import java.util.Date;
import java.util.List;

@Controller
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllBuyers")
    public @ResponseBody List<Buyer> getAllBuyerrs(){
        List<Buyer> buyers = buyerService.getAll();
        return buyers;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateBuyer")
    public ResponseEntity updateBuyer(
                                      @RequestParam(value = Buyer.ID_VALUE) Integer buyerId,
                                      @RequestParam(value = Buyer.FIRST_NAME_VALUE) String firstName,
                                      @RequestParam(value = Buyer.MIDDLE_NAME_VALUE) String middleName,
                                      @RequestParam(value = Buyer.LAST_NAME_VALUE) String lastName,
                                      @RequestParam(value = Buyer.BIRTH_DATE_VALUE) Long birthDate,
                                      @RequestParam(value = Buyer.LIVING_ADDRESS_VALUE) String livingAddress,
                                      @RequestParam(value = Buyer.PHONE_NUMBER_VALUE) String phoneNumber){
        try{
            Buyer updatedBuyer = buyerService.getBuyerById(buyerId);
            updatedBuyer.setFirstName(firstName);
            updatedBuyer.setMiddleName(middleName);
            updatedBuyer.setLastName(lastName);
            updatedBuyer.setBirthDate(new Date(birthDate));
            updatedBuyer.setLivingAddress(livingAddress);
            updatedBuyer.setPhoneNumber(phoneNumber);
            buyerService.updateBuyer(updatedBuyer);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBuyer")
    public ResponseEntity addBuyer(@RequestParam(value = Buyer.FIRST_NAME_VALUE) String firstName,
                         @RequestParam(value = Buyer.MIDDLE_NAME_VALUE) String middleName,
                         @RequestParam(value = Buyer.LAST_NAME_VALUE) String lastName,
                         @RequestParam(value = Buyer.BIRTH_DATE_VALUE) Long birthDate,
                         @RequestParam(value = Buyer.LIVING_ADDRESS_VALUE) String livingAddress,
                         @RequestParam(value = Buyer.PHONE_NUMBER_VALUE) String phoneNumber){
        Buyer buyer = new Buyer(firstName,middleName,lastName,new Date(birthDate),phoneNumber,livingAddress);
        try{
            buyerService.addBuyer(buyer);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteBuyer")
    public ResponseEntity deleteBuyer(@RequestParam(value = Buyer.ID_VALUE) Integer buyerId){
        try{
            Buyer deleted = buyerService.getBuyerById(buyerId);
            buyerService.removeBuyer(deleted);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //http://localhost:8080/crudGoods/index.html#/buyers
}
