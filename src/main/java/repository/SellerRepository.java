package repository;

import model.Seller;

import java.util.List;

public interface SellerRepository {

    List<Seller> getAllSellers();

    Seller getSellerById(Integer id);

    void addSeller(Seller seller);

    void updateSeller(Seller seller);

    void deleteSeller(Seller seller);
}
