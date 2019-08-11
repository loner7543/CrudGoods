package ru.ssau.controllers;

import model.Product;
import model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.impl.ProductRepositoryIImpl;
import repository.impl.SaleRepositoryImpl;
import service.ProductService;

import java.util.List;

@RestController(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleRepositoryImpl saleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAll();
        return products;
    }

    /*
     * Сохраняет продукт и связанную с ним продажу
     * */
    @RequestMapping(method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        Sale sale = saleService.getSaleById(product.getSale().getId());
        productService.saveProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product) {
        productService.update(product);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteProduct(@RequestParam(value = "id") Integer productId) {
        productService.delete(productId);
    }
}
