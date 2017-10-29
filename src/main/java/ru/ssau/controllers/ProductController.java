package ru.ssau.controllers;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST, value = "/getProducts")
    public @ResponseBody List<Product> getAllProducts(){
        List<Product> products =productService.getAll();
        return products;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveProduct")//++
    public ResponseEntity saveProduct(
            @RequestParam(value = Product.NAME_VALUE) String productName,
            @RequestParam(value = Product.UNIT_COAST_VALUE) Integer unitCoast,
            @RequestParam(value = Product.UNIT_NAME_VALUE) String unitName){

        Product product = new Product(productName,unitCoast,unitName);
        productService.saveProducr(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    // todo  Product передать через body запросом На клиенте его в body
    @RequestMapping(method = RequestMethod.PUT, value = "/updateProduct")
    public ResponseEntity updateProduct(@RequestParam(value = Product.ID_VALUE) Integer productId,
                              @RequestParam(value = Product.NAME_VALUE) String productName,
                              @RequestParam(value = Product.UNIT_COAST_VALUE) Integer unitCoast,
                              @RequestParam(value = Product.UNIT_NAME_VALUE) String unitName){
        Product product = productService.findProductById(productId);
        product.setName(productName);
        product.setUnitCoast(unitCoast);
        product.setUnitName(unitName);
        productService.update(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/removeProduct")
    public ResponseEntity deleteProduct( @RequestParam(value = Product.NAME_VALUE) Integer productId){
        Product product = productService.findProductById(productId);
        productService.delete(product);
        return new ResponseEntity(HttpStatus.OK);
    }
}
