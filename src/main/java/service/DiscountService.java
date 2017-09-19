package service;

import model.Discount;
import model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class DiscountService {

    @PersistenceContext
    private EntityManager entityManager;

    public DiscountService(){

    }

    @Transactional
    public List<Discount> getAllDisc(){
        String query = "from Discount order by id";
        TypedQuery<Discount> typedQuery = entityManager.createQuery(query, Discount.class);
        return typedQuery.getResultList();
    }
}
