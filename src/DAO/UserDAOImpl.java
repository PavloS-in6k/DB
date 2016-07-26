package DAO;

import Entinity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAOImpl {
    private SessionFactory sessionFactory;

    public User getUserByID(int key) {
        Session session = sessionFactory.openSession();
        User user = null;
        try {
            user = session.get(User.class, key);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public void setConnectionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}


//    public void setDatabaseTester(IDatabaseTester databaseTester) {
//        this.databaseTester = databaseTester;
//    }
//
//    public User getUserByID(String key) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select UserName FROM Users WHERE ID=" + key);
//
//        int ID = Integer.parseInt(key);
//        String name = "";
//        if (rs.next()) {
//            name = rs.getString("UserName");
//        }
//        rs.close();
//        stmt.close();
//        return new User(ID, name);
//    }
//
//    public List<Order> getUserOrders (String key) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select Orders.ID FROM Orders WHERE UserID=" + key);
//
//        List<Order> orders = new ArrayList<>();
//        if (rs.next()) {
//            orders.add(orderDAO.getOrderByID(rs.getString("ID ")));
//        }
//        rs.close();
//        stmt.close();
//        return orders;
//    }

