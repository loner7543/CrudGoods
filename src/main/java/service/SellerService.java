package service;

import model.Product;
import model.Seller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SellerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Seller> getAllSellers(){
        String query = "from Seller order by id";
        TypedQuery<Seller> typedQuery = entityManager.createQuery(query, Seller.class);
        return typedQuery.getResultList();
    }

    @Transactional
    public Seller getSellerById(int id){
        return entityManager.find(Seller.class,id);
    }

    @Transactional
    public void addSeller(Seller seller){
       entityManager.persist(seller);
    }

    @Transactional
    public void updateSeller(Seller seller){
        entityManager.merge(seller);
    }

    @Transactional
    public void deleteSeller(Seller seller){
        entityManager.remove(seller);
    }
}
