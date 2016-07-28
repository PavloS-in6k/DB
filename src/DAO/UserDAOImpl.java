package DAO;

import Entity.User;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDAOImpl {
    private SessionFactory sessionFactory;

    public User getUserByID(int key) {
        return sessionFactory.getCurrentSession().get(User.class, key);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

