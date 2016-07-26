package DAO;

import Entinity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl {
    private SessionFactory sessionFactory;

    public Category getCategory(int key) {
        Category requestedCategory = null;
        Session session = sessionFactory.openSession();
        try {
            requestedCategory = session.get(Category.class, key);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return requestedCategory;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            categories = session.createQuery("FROM Category").getResultList();
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }

    public void setSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}


//
//    public List<Category> getAllCategories() throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery("select * FROM Categories");
//
//        List<Category> categories = new ArrayList<>();
//        int ID;
//        String name;
//        while (rs.next()) {
//            ID = rs.getInt("ID");
//            name = rs.getString("CategoryName");
//            categories.add(new Category(ID, name));
//        }
//
//        return categories;
//    }


//    public static Category getCategory(String key) throws Exception {
//
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select CategoryName FROM Categories WHERE ID=" + key);
//
//        int ID = Integer.parseInt(key);
//        List<Product> products = productDAO.getProductsByCategory(key);
//        String name = "";
//        if (rs.next()) {
//            name = rs.getString("CategoryName");
//        }
//        rs.close();
//        stmt.close();
//        return (new Category(ID, name));
//    }