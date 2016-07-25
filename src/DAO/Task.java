package DAO;

import Entinity.TaskEntity.ItemCount;
import org.dbunit.IDatabaseTester;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private IDatabaseTester databaseTester;
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    public void setCategoryDAO(CategoryDAOImpl categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void setConnection(IDatabaseTester databaseTester) {
        this.databaseTester = databaseTester;
        categoryDAO.setConnection(databaseTester);
    }

    public List<ItemCount> getCategoriesWithCounts() throws Exception {
        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT Categories.CategoryName, Count(Products.ID) AS ProductCount " +
                        "FROM Categories, Products " +
                        "WHERE Products.CategoryID = Categories.ID " +
                        "group BY Categories.category_name");

        List<ItemCount> itemCounts = new ArrayList<>();
        String name;
        int count;
        while (rs.next()) {
            name = rs.getString("CategoryName");
            count = rs.getInt("NumberOfProducts");
            itemCounts.add(new ItemCount(name, count));
        }
        return (itemCounts);
    }

    public List<ItemCount> getTop3(String categoryName) throws Exception {
        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT TOP 3 Products.ProductName, COUNT(OrderProducts.ProductID) AS OrderCount " +
                        "from Products, Orders, Categories, OrderProducts " +
                        "where Products.ID = OrderProducts.ProductID " +
                        "AND Orders.ID = OrderProducts.OrderID " +
                        "AND ((TODAY - CAST(Orders.TimeStamp AS DATE)) <= 60) " +
                        "AND Products.CategoryID = Categories.ID " +
                        "AND Categories.CategoryName = '" + categoryName + "' " +
                        "GROUP BY Products.ProductName " +
                        "ORDER BY OrderCount DESC");

        List<ItemCount> itemCounts = new ArrayList<>();
        String name;
        int count;
        while (rs.next()) {
            name = rs.getString("ProductName");
            count = rs.getInt("OrderCount");
            itemCounts.add(new ItemCount(name, count));
        }
        return (itemCounts);
    }
}