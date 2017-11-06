package service;

import model.Sale;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SaleService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Sale> getAllSells(){
        String query = "from Sale order by id";
        TypedQuery<Sale> typedQuery = entityManager.createQuery(query, Sale.class);
        List<Sale> sales = typedQuery.getResultList();
        sales.forEach( elm -> {
            elm.getProducts().size();// lazy init
        });
        sales.forEach(s->s.getProducts().forEach(product -> product.getDiscounts().size()));
        sales.forEach(elm->elm.getBuyer().getDiscounts().size());
        return sales;
    }

    @Transactional
    public void addSale(Sale sale){
        entityManager.persist(sale);
    }

    @Transactional
    public void updateSale(Sale sale){
        entityManager.merge(sale);
    }

    @Transactional
    public Sale getSaleById(int id) {
        return entityManager.find(Sale.class,id);
    }

    @Transactional
    public void deleteSale(Sale sale){
        entityManager.remove(entityManager.contains(sale) ? sale : entityManager.merge(sale));
    }



}
