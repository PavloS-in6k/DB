package DAO;

import Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAOImpl {
    private SessionFactory sessionFactory;

    public Product getProduct(int key) {
        Session session = sessionFactory.openSession();
        Product product = null;
        try {
            product = session.get(Product.class, key);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return product;
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

    //    protected List<Product> getProductsByCategory(String key) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select ID, ProductName, Price, CategoryID " +
//                        "FROM Products " +
//                        "WHERE Products.CategoryID=" + key);
//
//        List<Product> products = new ArrayList<>();
//        int ID;
//        String name;
//        BigDecimal price;
//        Category category;
//        while (rs.next()) {
//            ID = rs.getInt("ID");
//            name = rs.getString("ProductName");
//            price = rs.getBigDecimal("Price");
//            category = CategoryDAOImpl.getCategory(String.valueOf(rs.getInt("CategoryID")));
//            products.add(new Product(ID, price, name, category));
//        }
//
//        rs.close();
//        stmt.close();
//        return (products);
//    }
//
//    protected int getCategoryID(Product product) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select CategoryID " +
//                        "FROM Categories " +
//                        "WHERE Products.CategoryID=" + product.getID());
//        int ID = -1;
//        while (rs.next()) {
//            ID = rs.getInt("CategoryID");
//        }
//        rs.close();
//        stmt.close();
//        return ID;
//    }
//
//    public Product getProductByID(String key) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select ProductName, Price, CategoryID " +
//                        "FROM Products " +
//                        "WHERE Products.ID=" + key);
//
//        int ID = -1;
//        String name = "";
//        BigDecimal price = null;
//        while (rs.next()) {
//            ID = rs.getInt("CategoryID");
//            name = rs.getString("ProductName");
//            price = rs.getBigDecimal("Price");
//        }
//        rs.close();
//        stmt.close();
//        return new Product(ID, price, name, CategoryDAOImpl.getCategory((key)));
//    }
}
