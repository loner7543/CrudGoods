package service;

import model.Buyer;

import java.util.List;

public interface BuyerService {

    List<Buyer> getAllI();

    void addBuyer(Buyer buyer);

    void updateBuyer(Buyer buyer);

    Buyer getBuyerById(Integer id);

    void removeBuyer(Buyer buyer);
}
