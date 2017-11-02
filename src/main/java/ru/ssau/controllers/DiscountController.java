package ru.ssau.controllers;

import model.Discount;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DiscountService;

import java.util.Date;
import java.util.List;

//todo replace all null's values
@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @RequestMapping(method = RequestMethod.POST, value = "/getDiscounts")
    public @ResponseBody List<Discount> getAddDiscounts(){
        List<Discount> discounts = discountService.getAllDisc();
        return discounts;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addDiscount")
    public ResponseEntity addNewDiscount(@RequestParam(value = Discount.ACTUAL_FROM_VALUE) Long actualFrom,
                               @RequestParam(value = Discount.ACTUAL_TO_VALUE) Long actualTo,
                               @RequestParam(value = Discount.AMOUNT_DISCOUNT_VALUE) Integer amountDiscount){
        Discount discount = new Discount(new Date(actualFrom),new Date(actualTo),amountDiscount,null,null);
        discountService.addDiscount(discount);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateDiscount")
    public ResponseEntity updateDiscount(
                                @RequestParam(value = Discount.ID_VALUE) Integer discountId,
                                @RequestParam(value = Discount.ACTUAL_FROM_VALUE) Long newActualFromDate,
                                @RequestParam(value = Discount.ACTUAL_TO_VALUE) Long newActualToDate,
                                @RequestParam(value = Discount.AMOUNT_DISCOUNT_VALUE) Integer newAmountDiscount){
        Discount updated = discountService.findDiscountById(discountId);
        updated.setActualFrom(new Date(newActualFromDate));
        updated.setActualTo(new Date(newActualToDate));
        updated.setAmountDiscount(newAmountDiscount);
        discountService.updateDiscount(updated);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteDiscount")
    public ResponseEntity deleteDiscount(@RequestParam(value = Discount.ID_VALUE) Integer discountId){
        Discount deleted = discountService.findDiscountById(discountId);
        discountService.deleteDiscount(deleted);
        return new ResponseEntity(HttpStatus.OK);
    }
}
