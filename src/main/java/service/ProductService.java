package service;

import model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductService() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Product> getAll(){//++
        String query = "from Product order by id";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        List<Product> resultList = typedQuery.getResultList();
        resultList.forEach( elm -> {
            elm.getDiscounts().size();
        });
        return resultList;
    }

    @Transactional
    public void saveProducr(Product product){
        entityManager.persist(product);
    }

    @Transactional
    public void removeProduct(Product product){
        entityManager.remove(product);
    }

    @Transactional
    public Product findProductById(int id){
        return entityManager.find(Product.class,id);
    }

    @Transactional
    public void update(Product product){
        entityManager.merge(product);
    }

    @Transactional
    public void delete(Product product){
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }


}
