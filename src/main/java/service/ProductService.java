package service;

import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void saveProduct(Product product);

    void update(Product product);

    void delete(Integer id);

    Product findProductById(Integer id);
}
