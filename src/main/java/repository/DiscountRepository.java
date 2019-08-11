package repository;

import model.Discount;

import java.util.List;

public interface DiscountRepository {

    List<Discount> getAllDisc();

    void addDiscount(Discount discount);

    void updateDiscount(Discount discount);

    void deleteDiscount(Discount discount);
}
