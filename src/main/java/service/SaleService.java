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
        String query = "from Seller order by id";
        TypedQuery<Sale> typedQuery = entityManager.createQuery(query, Sale.class);
        return typedQuery.getResultList();
    }

    public void addSale(Sale sale){
        entityManager.persist(sale);
    }

    public void updateSale(Sale sale){
        entityManager.merge(sale);
    }

    public Sale getSaleById(int id) {
        return entityManager.find(Sale.class,id);
    }

    public void deleteSale(Sale sale){
        entityManager.remove(sale);
    }



}
