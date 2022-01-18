package qk.customer_management.repository;

import qk.customer_management.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        String queryStr = "select C from Customer as C";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr,Customer.class);

        return query.getResultList();
    }

    @Override
    public Customer findByID(Long id) {
        String queryStr = "select C from Customer as C where C.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr,Customer.class);
        query.setParameter("id",id);

        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null)
            entityManager.merge(customer);
        else
            entityManager.persist(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer = this.findByID(id);

        if (customer != null)
            entityManager.remove(customer);
    }
}
