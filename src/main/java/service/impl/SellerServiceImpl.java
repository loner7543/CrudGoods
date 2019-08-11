package service.impl;

import model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SellerRepository;
import service.SellerService;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.getAllSellers();
    }

    @Override
    public void addSeller(Seller seller) {
        sellerRepository.addSeller(seller);
    }

    @Override
    public void updateSeller(Seller seller) {
        sellerRepository.updateSeller(seller);
    }

    @Override
    public void deleteSeller(Integer id) {
        Seller deleted = sellerRepository.getSellerById(id);
        sellerRepository.deleteSeller(deleted);
    }
}
