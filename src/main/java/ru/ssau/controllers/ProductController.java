package ru.ssau.controllers;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(method = RequestMethod.GET, value = "/saveProduct")//++
    public void saveProduct(){
        Product product = new Product("chocolate",12,"in");
        productService.saveProducr(product);
        String s = "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateProduct")
    public void updateProduct(){
        Product product = new Product(23,"qwe",12,"in");
        productService.update(product);
        String s = "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/removeProduct")
    public void deleteProduct(){
        Product product = new Product(19,"qwe",12,"in");
        productService.delete(product);
        String s = "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")//++
    public @ResponseBody Product getProductById(){
        Product product = productService.findProductById(24);
        return product;
    }
}
