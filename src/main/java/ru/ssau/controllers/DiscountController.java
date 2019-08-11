package ru.ssau.controllers;

import model.Buyer;
import model.Discount;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.impl.BuyerRepositoryImpl;
import repository.impl.DiscountRepositoryImpl;
import repository.impl.ProductRepositoryIImpl;
import service.DiscountService;

import java.util.Date;
import java.util.Dictionary;
import java.util.List;

//todo Документация
@RestController(value = "discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private ProductRepositoryIImpl productService;

    @Autowired
    private BuyerRepositoryImpl buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Discount> getAddDiscounts() {
        List<Discount> discounts = discountService.getAllDisc();
        return discounts;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewDiscount(@RequestBody Discount d) {
        Product product = productService.findProductById(d.getProduct().getId());
        Buyer buyer = buyerService.getBuyerById(d.getBuyer().getId());
        Discount discount = new Discount(d.getActualFrom(), d.getActualTo(), d.getAmountDiscount(), product, buyer);
        discountService.addDiscount(discount);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateDiscount(@RequestBody Discount discount) {
        Product product = productService.findProductById(discount.getProduct().getId());
        Buyer buyer = buyerService.getBuyerById(discount.getBuyer().getId());
        discount.setBuyer(buyer);
        discount.setProduct(product);
        discountService.updateDiscount(discount);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteDiscount(@RequestParam(value = "id") Integer discountId) {
        discountService.deleteDiscount(discountId);
    }
}
