package repository;

import model.Sale;

import java.util.List;

public interface SaleRepository {

    List<Sale> getAllSells();

    void addSale(Sale sale);

    void updateSale(Sale sale);

    void deleteSale(Integer id);

    Sale find(Integer id);
}
