package service;

import model.Sale;

import java.util.List;

public interface SaleService {

    List<Sale> getAllSells();

    void addSale(Sale sale);

    void updateSale(Sale sale);

    void deleteSale(Integer id);
}
