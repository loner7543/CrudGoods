package repository.impl;

import model.Buyer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.BuyerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BuyerRepositoryImpl implements BuyerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Buyer> getAll(){
        String query = "from Buyer order by id";
        TypedQuery<Buyer> typedQuery = entityManager.createQuery(query, Buyer.class);
        List<Buyer> buyers = typedQuery.getResultList();
        buyers.forEach( elm -> {
            elm.getDiscounts().size();
        });
        return buyers;
    }

    public void addBuyer(Buyer buyer){
        entityManager.persist(buyer);
    }

    public void updateBuyer(Buyer newBuyer){
        entityManager.merge(newBuyer);
    }

    public Buyer getBuyerById(int id){
        return entityManager.find(Buyer.class,id);
    }

    public void removeBuyer(Buyer buyer){
        entityManager.remove(entityManager.contains(buyer) ? buyer : entityManager.merge(buyer));
    }
}
