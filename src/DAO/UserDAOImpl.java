package DAO;

import Entinity.Order;
import Entinity.User;
import org.dbunit.IDatabaseTester;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl {
    private IDatabaseTester databaseTester;
    private OrderDAOImpl orderDAO = new OrderDAOImpl();

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
}

