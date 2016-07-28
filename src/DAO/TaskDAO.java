package DAO;

import Entity.Category;
import Entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TaskDAO {
    private SessionFactory sessionFactory;

    public List<Category> getAllCategoriesWithNumbers() {
        return sessionFactory.getCurrentSession().createQuery(
                "SELECT new Entity.Category(category.name, category.ID, COUNT(product.category)) " +
                        "FROM Category category, Product product " +
                        "where category.ID=product.category.ID " +
                        "group by category.name, category.ID").getResultList();
    }

    public List<Category> getTop3(Category product) {
        return sessionFactory.getCurrentSession().createQuery(
                "SELECT  product\n" +
                        "FROM  Product product, Order order\n" +
                        "WHERE (\n" +
                        "(Category.ID=Product.category.ID) \n" +
                        "AND (Order.timeStamp=current_date)\n" +
                        "  )\n" +
                        "GROUP BY ").getResultList();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

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