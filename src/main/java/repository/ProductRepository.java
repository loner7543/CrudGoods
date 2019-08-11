package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    void saveProduct(Product product);

    void removeProduct(Product product);

    Product findProductById(Integer id);

    void update(Product product);

    void delete (Product product);
}
