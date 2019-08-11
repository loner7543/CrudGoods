package service.impl;

import model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SaleRepository;
import service.SaleService;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSells() {
        return saleRepository.getAllSells();
    }

    @Override
    public void addSale(Sale sale) {
        saleRepository.addSale(sale);
    }

    @Override
    public void updateSale(Sale sale) {
        saleRepository.updateSale(sale);
    }

    @Override
    public void deleteSale(Integer id) {
        saleRepository.deleteSale(id);
    }
}
