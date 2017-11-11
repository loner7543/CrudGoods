package ru.ssau.controllers;

import model.Product;
import model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;
import service.SaleService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @RequestMapping(method = RequestMethod.GET, value = "/getProducts")
    public @ResponseBody List<Product> getAllProducts(){
        List<Product> products =productService.getAll();
        return products;
    }

    /*
    * Сохраняет продукт и связанную с ним продажу
    * */
    @RequestMapping(method = RequestMethod.POST, value = "/saveProduct")//++
    public ResponseEntity saveProduct(
            @RequestParam(value = Product.NAME_VALUE) String productName,
            @RequestParam(value = Product.UNIT_COAST_VALUE) Integer unitCoast,
            @RequestParam(value = Product.UNIT_NAME_VALUE) String unitName,
            @RequestParam(value = Product.SALE_ID) Integer saleId ){
        Sale sale = saleService.getSaleById(saleId);
        Product product = new Product(productName,unitCoast,unitName,sale);
        productService.saveProducr(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    // todo  Product передать через body запросом На клиенте его в body
    @RequestMapping(method = RequestMethod.PUT, value = "/updateProduct")
    public ResponseEntity updateProduct(@RequestBody Product newProduct){
        Product product = productService.findProductById(newProduct.getId());
//        product.setName(productName);
//        product.setUnitCoast(unitCoast);
//        product.setUnitName(unitName);
        productService.update(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProduct")
    public ResponseEntity deleteProduct( @RequestParam(value = Product.ID_VALUE) Integer productId){
        Product product = productService.findProductById(productId);
        productService.delete(product);
        return new ResponseEntity(HttpStatus.OK);
    }
}
