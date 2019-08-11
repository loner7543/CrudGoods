package repository.impl;

import model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryIImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductRepositoryIImpl() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getAll(){//++
        String query = "from Product order by id";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        List<Product> resultList = typedQuery.getResultList();
        resultList.forEach( elm -> {
            elm.getDiscounts().size();
        });
        return resultList;
    }

    public void saveProduct(Product product){
        entityManager.persist(product);
    }

    public void removeProduct(Product product){
        entityManager.remove(product);
    }

    public Product findProductById(Integer id){
        return entityManager.find(Product.class,id);
    }

    public void update(Product product){
        entityManager.merge(product);
    }

    public void delete(Product product){
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }


}
