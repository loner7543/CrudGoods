package repository.impl;

import model.Discount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.DiscountRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
@Transactional
public class DiscountRepositoryImpl implements DiscountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DiscountRepositoryImpl(){

    }

    public List<Discount> getAllDisc(){
        String query = "from Discount order by id";
        TypedQuery<Discount> typedQuery = entityManager.createQuery(query, Discount.class);
        List<Discount> discounts = typedQuery.getResultList();
        return discounts;
    }

    public void addDiscount(Discount discount){
        entityManager.merge(discount);
    }

    public void updateDiscount(Discount discount){
        entityManager.merge(discount);
    }

    public Discount findDiscountById(int id){
        return entityManager.find(Discount.class,id);
    }

    public void deleteDiscount(Discount discount){
        entityManager.remove(entityManager.contains(discount) ? discount : entityManager.merge(discount));
    }
}
