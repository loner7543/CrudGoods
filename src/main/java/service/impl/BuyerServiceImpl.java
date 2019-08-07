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

    }

    @Override
    public void updateBuyer(Buyer buyer) {

    }

    @Override
    public Buyer getBuyerById(Integer id) {
        return null;
    }

    @Override
    public void removeBuyer(Buyer buyer) {

    }
}
