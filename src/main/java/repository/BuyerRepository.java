package repository;

import model.Buyer;

import java.util.List;

public interface BuyerRepository {

    List<Buyer> getAll();

    void addBuyer(Buyer buyer);

    void updateBuyer(Buyer buyer);

    Buyer getBuyerById(Integer id);

    void removeBuyer(Buyer buyer);
}
