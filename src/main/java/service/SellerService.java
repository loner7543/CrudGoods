package service;

import model.Sale;
import model.Seller;

import java.util.List;

public interface SellerService {

    List<Seller> getAllSellers();

    void addSeller(Seller seller);

    void updateSeller(Seller seller);

    void deleteSeller(Integer id);
}
