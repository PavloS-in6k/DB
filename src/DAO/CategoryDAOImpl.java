package DAO;

import Entinity.Category;
import Entinity.Product;
import org.dbunit.IDatabaseTester;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl {
    private IDatabaseTester databaseTester;
    private ProductDAOImpl productDAO;

    public void setProductDAO(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }


    public void setConnection(IDatabaseTester databaseTester) {
        this.databaseTester = databaseTester;
        productDAO.setConnection(this.databaseTester);
    }


    public Category getCategory(String key) throws Exception {
        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(
                "select CategoryName FROM Categories WHERE ID=" + key);

        int ID = Integer.parseInt(key);
        List<Product> products = productDAO.getProductsByCategory(key);
        String name = "";
        if (rs.next()) {
            name = rs.getString("CategoryName");
        }
        rs.close();
        stmt.close();
        return (new Category(ID, name, products));
    }

    public List<Category> getAllCategories() throws Exception {
        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("select * FROM Categories");

        List<Category> categories = new ArrayList<>();
        int ID;
        String name;
        while (rs.next()) {
            ID = rs.getInt("ID");
            name = rs.getString("CategoryName");
            categories.add(new Category(ID, name, productDAO.getProductsByCategory(String.valueOf(ID))));
        }

        return categories;
    }
}
