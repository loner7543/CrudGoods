package service;

import model.Buyer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BuyerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Buyer> getAll(){//++
        String query = "from Buyer order by id";
        TypedQuery<Buyer> typedQuery = entityManager.createQuery(query, Buyer.class);
        return typedQuery.getResultList();
    }
}
