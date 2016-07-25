package DAO;

import Entinity.Category;
import Entinity.Product;
import org.dbunit.IDatabaseTester;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl {
    private IDatabaseTester databaseTester;

    public void setConnection(IDatabaseTester databaseTester) {
        this.databaseTester = databaseTester;
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
