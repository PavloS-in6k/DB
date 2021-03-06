package DAO;

import Entinity.Order;
import Entinity.Product;
import Entinity.User;
import org.dbunit.IDatabaseTester;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl {
    private IDatabaseTester databaseTester;
    private UserDAOImpl userDAO;
    private ProductDAOImpl productDAO = new ProductDAOImpl();

    public void setConnection(IDatabaseTester databaseTester) {
        this.databaseTester = databaseTester;
        userDAO.setDatabaseTester(databaseTester);
        productDAO.setConnection(databaseTester);
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public Order getOrderByID(String key) throws Exception {
        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(
                "select UserID, TimeStamp, Price FROM Orders WHERE ID=" + key);
        User user = null;
        LocalDateTime timeStamp = null;
        List<Product> products = null;
        BigDecimal cost = null;
        int ID = Integer.parseInt(key);
        while (rs.next()) {
            user = userDAO.getUserByID(String.valueOf(rs.getInt("UserID")));
            timeStamp = rs.getTimestamp("TimeStamp").toLocalDateTime();
            cost = rs.getBigDecimal("Price");
            products = getOrderProducts(key);
        }
        rs.close();
        stmt.close();

        return new Order(user, timeStamp, products, cost);
    }

    private List<Product> getOrderProducts(String key) throws Exception {
        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(
                "select ProductID FROM OrderProducts WHERE OrderID=" + key);

        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            products.add(productDAO.getProductByID(String.valueOf(rs.getInt("ProductID"))));
        }
        return products;
    }
}