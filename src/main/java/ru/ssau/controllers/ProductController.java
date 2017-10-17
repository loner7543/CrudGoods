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

    @RequestMapping(method = RequestMethod.GET, value = "/getProducts")
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
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateProduct")
    public void updateProduct(@RequestParam(value = Product.ID_VALUE) Integer productId,
                              @RequestParam(value = Product.NAME_VALUE) String productName,
                              @RequestParam(value = Product.UNIT_COAST_VALUE) Integer unitCoast,
                              @RequestParam(value = Product.UNIT_NAME_VALUE) String unitName){
        Product product = productService.findProductById(productId);
        product.setName(productName);
        product.setUnitCoast(unitCoast);
        product.setUnitName(unitName);
        productService.update(product);
        String s = "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/removeProduct")
    public void deleteProduct( @RequestParam(value = Product.NAME_VALUE) Integer productId){
        Product product = productService.findProductById(productId);
        productService.delete(product);
        String s = "";
    }
}
