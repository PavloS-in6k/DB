package DAO;

import Entinity.Category;
import Entinity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private SessionFactory sessionFactory;

    public List<Category> getAllCategoriesWithNumbers() {
        List<Category> categories = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            categories = session.createQuery(
                    "SELECT new Entinity.Category(category.name, category.ID, COUNT(product.category)) " +
                            "FROM Category category, Product product " +
                            "where category.ID=product.category.ID " +
                            "group by category.name, category.ID").getResultList();

        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return categories;
    }


    public void setConnectionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getAllItemsForOrderID(int key) {
        List<Product> requestedItems = null;
        Session session = sessionFactory.openSession();
        try {
            //requestedItems = session.get(Category.class, key);
            requestedItems = session.createQuery(
                    "SELECT new Entinity.Product() " +
                            "FROM ").getResultList();
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return requestedItems;
    }
}

//    private IDatabaseTester databaseTester;
//
//    public void setConnection(IDatabaseTester databaseTester) {
//        this.databaseTester = databaseTester;
//    }
//
//    public List<ItemCount> getCategoriesWithCounts() throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "SELECT Categories.CategoryName, Count(Products.ID) AS ProductCount " +
//                        "FROM Categories, Products " +
//                        "WHERE Products.CategoryID = Categories.ID " +
//                        "group BY Categories.category_name");
//
//        List<ItemCount> itemCounts = new ArrayList<>();
//        String name;
//        int count;
//        while (rs.next()) {
//            name = rs.getString("CategoryName");
//            count = rs.getInt("NumberOfProducts");
//            itemCounts.add(new ItemCount(name, count));
//        }
//        return (itemCounts);
//    }
//
//    public List<ItemCount> getTop3(String categoryName) throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "SELECT TOP 3 Products.ProductName, COUNT(OrderProducts.ProductID) AS OrderCount " +
//                        "from Products, Orders, Categories, OrderProducts " +
//                        "where Products.ID = OrderProducts.ProductID " +
//                        "AND Orders.ID = OrderProducts.OrderID " +
//                        "AND ((TODAY - CAST(Orders.TimeStamp AS DATE)) <= 60) " +
//                        "AND Products.CategoryID = Categories.ID " +
//                        "AND Categories.CategoryName = '" + categoryName + "' " +
//                        "GROUP BY Products.ProductName " +
//                        "ORDER BY OrderCount DESC");
//
//        List<ItemCount> itemCounts = new ArrayList<>();
//        String name;
//        int count;
//        while (rs.next()) {
//            name = rs.getString("ProductName");
//            count = rs.getInt("OrderCount");
//            itemCounts.add(new ItemCount(name, count));
//        }
//        return (itemCounts);
//    }