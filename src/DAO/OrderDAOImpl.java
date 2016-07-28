package DAO;

import Entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrderDAOImpl {
    private SessionFactory sessionFactory;

    public Order getOrderByID(int key) {
        return sessionFactory.getCurrentSession().get(Order.class, key);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
//
//    public void setConnection(IDatabaseTester databaseTester) {
//        this.databaseTester = databaseTester;
//        userDAO.setDatabaseTester(databaseTester);
//        productDAO.setConnection(databaseTester);
//    }
//
//    public void setUserDAO(UserDAOImpl userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    public Order getOrderByID(String key) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select UserID, TimeStamp, Price FROM Orders WHERE ID=" + key);
//        User user = null;
//        LocalDateTime timeStamp = null;
//        BigDecimal cost = null;
//        int ID = Integer.parseInt(key);
//        while (rs.next()) {
//            user = userDAO.getUserByID(String.valueOf(rs.getInt("UserID")));
//            timeStamp = rs.getTimestamp("TimeStamp").toLocalDateTime();
//            cost = rs.getBigDecimal("Price");
//        }
//        rs.close();
//        stmt.close();
//
//        return new Order(user, timeStamp, cost, ID);
//    }
//
//    public List<Product> getOrderProducts(String key) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select ProductID FROM OrderProducts WHERE OrderID=" + key);
//
//        List<Product> products = new ArrayList<>();
//        while (rs.next()) {
//            products.add(productDAO.getProductByID(String.valueOf(rs.getInt("ProductID"))));
//        }
//        return products;
//    }