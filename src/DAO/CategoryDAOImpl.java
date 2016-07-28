package DAO;

import Entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CategoryDAOImpl {
    private SessionFactory sessionFactory;

    public Category getCategory(int key) {
        return sessionFactory.getCurrentSession().get(Category.class, key);
    }

    public List<Category> getAllCategories() {
        return (List<Category>) sessionFactory.getCurrentSession().createQuery("FROM Category").getResultList();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}