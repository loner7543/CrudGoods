package service.impl;

import model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DiscountRepository;
import repository.impl.DiscountRepositoryImpl;
import service.DiscountService;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> getAllDisc() {
        return discountRepository.getAllDisc();
    }

    @Override
    public void addDiscount(Discount discount) {
        discountRepository.addDiscount(discount);
    }

    @Override
    public void updateDiscount(Discount discount) {
        discountRepository.updateDiscount(discount);
    }

    @Override
    public void deleteDiscount(Integer id) {
        Discount deleted = findDiscountById(id);
        discountRepository.deleteDiscount(deleted);
    }

    @Override
    public Discount findDiscountById(Integer id) {
        return null;
    }
}
