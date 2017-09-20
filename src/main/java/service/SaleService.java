package service;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SaleService {
    @PersistenceContext
    private EntityManager entityManager;

}
