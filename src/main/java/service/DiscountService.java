package service;

import model.Discount;

import java.util.List;

public interface DiscountService {
    List<Discount> getAllDisc();

    void addDiscount(Discount discount);

    void updateDiscount(Discount discount);

    void deleteDiscount(Integer id);

    Discount findDiscountById(Integer id);
}
