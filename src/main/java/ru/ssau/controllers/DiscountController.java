package ru.ssau.controllers;

import model.Buyer;
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
import service.BuyerService;
import service.DiscountService;
import service.ProductService;

import java.util.Date;
import java.util.List;

@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getDiscounts")
    public @ResponseBody List<Discount> getAddDiscounts(){
        List<Discount> discounts = discountService.getAllDisc();
        return discounts;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addDiscount")
    public ResponseEntity addNewDiscount(
                                            @RequestParam(value = Discount.ACTUAL_FROM_VALUE) Long actualFrom,
                                            @RequestParam(value = Discount.ACTUAL_TO_VALUE) Long actualTo,
                                            @RequestParam(value = Discount.AMOUNT_DISCOUNT_VALUE) Integer amountDiscount,
                                            @RequestParam(value = Discount.PRODUCT_ID) Integer productId,
                                            @RequestParam(value = Discount.BUYER_ID) Integer buyerId){
        Product product = productService.findProductById(productId);
        Buyer buyer = buyerService.getBuyerById(buyerId);
        Discount discount = new Discount(new Date(actualFrom),new Date(actualTo),amountDiscount,product,buyer);
        try {
            discountService.addDiscount(discount);
        } catch (Exception e) {
            new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);//todo detached entity passed to persist - persist ot merge-fixed
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateDiscount")
    public ResponseEntity updateDiscount(
                                @RequestParam(value = Discount.ID_VALUE) Integer discountId,
                                @RequestParam(value = Discount.ACTUAL_FROM_VALUE) Long newActualFromDate,
                                @RequestParam(value = Discount.ACTUAL_TO_VALUE) Long newActualToDate,
                                @RequestParam(value = Discount.AMOUNT_DISCOUNT_VALUE) Integer newAmountDiscount,
                                @RequestParam(value = Discount.BUYER_ID) Integer buyerId,
                                @RequestParam(value = Discount.PRODUCT_ID) Integer productId){
        try{
            Product product = productService.findProductById(productId);
            Buyer buyer = buyerService.getBuyerById(buyerId);
            Discount updated = discountService.findDiscountById(discountId);
            updated.setActualFrom(new Date(newActualFromDate));
            updated.setActualTo(new Date(newActualToDate));
            updated.setAmountDiscount(newAmountDiscount);
            updated.setBuyer(buyer);
            updated.setProduct(product);
            discountService.updateDiscount(updated);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteDiscount")
    public ResponseEntity deleteDiscount(@RequestParam(value = Discount.ID_VALUE) Integer discountId){
        Discount deleted = discountService.findDiscountById(discountId);
        try{
            discountService.deleteDiscount(deleted);
        }
        catch (Throwable e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
