package repository.impl;

import model.Seller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.SellerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SellerRepositoryImpl implements SellerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Seller> getAllSellers(){
        String query = "from Seller order by id";
        TypedQuery<Seller> typedQuery = entityManager.createQuery(query, Seller.class);
        List<Seller> sellers = typedQuery.getResultList();
        sellers.forEach(seller->seller.getSale().getProducts().size());
        sellers.forEach(seller -> seller.getSale().getProducts().forEach(product -> product.getDiscounts().size()));
        sellers.forEach(seller -> seller.getSale().getBuyer().getDiscounts().size());
        return sellers;
    }


    public Seller getSellerById(Integer id){
        return entityManager.find(Seller.class,id);
    }


    public void addSeller(Seller seller){
       entityManager.merge(seller);
    }


    public void updateSeller(Seller seller){
        entityManager.merge(seller);
    }


    public void deleteSeller(Seller seller){
        entityManager.remove(entityManager.contains(seller) ? seller : entityManager.merge(seller));
    }
}
