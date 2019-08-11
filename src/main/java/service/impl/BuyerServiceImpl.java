package service.impl;

import model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BuyerRepository;
import service.BuyerService;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Buyer> getAllI() {
        return buyerRepository.getAll();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyerRepository.addBuyer(buyer);
    }

    @Override
    public void updateBuyer(Buyer buyer) {
        buyerRepository.updateBuyer(buyer);
    }

    @Override
    public Buyer getBuyerById(Integer id) {
        return buyerRepository.getBuyerById(id);
    }

    @Override
    public void removeBuyer(Buyer buyer) {
        buyerRepository.removeBuyer(buyer);
    }
}
