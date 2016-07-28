package DAO;

import Entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ProductDAOImpl {
    private SessionFactory sessionFactory;

    public Product getProduct(int key) {
        return sessionFactory.getCurrentSession().get(Product.class, key);
    }


    public void setConnectionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
