package repository.impl;

import model.Sale;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.SaleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SaleRepositoryImpl implements SaleRepository {
    @PersistenceContext
    private EntityManager entityManager;


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

    public void addSale(Sale sale){
        entityManager.merge(sale);
    }

    public void updateSale(Sale sale){
        entityManager.merge(sale);
    }

    public Sale getSaleById(int id) {
        return entityManager.find(Sale.class,id);
    }

    public void deleteSale(Integer id){
        Sale sale = find(id);
        entityManager.remove(entityManager.contains(sale) ? sale : entityManager.merge(sale));
    }

    @Override
    public Sale find(Integer id) {
        return entityManager.find(Sale.class,id);
    }


}
