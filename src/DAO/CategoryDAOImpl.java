package DAO;

import Entinity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDAOImpl {
    private Session session;

    public Category getCategory(String key) {
        Transaction transaction;



        return null;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}


//
//    public List<Category> getAllCategories() throws Exception {
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery("select * FROM Categories");
//
//        List<Category> categories = new ArrayList<>();
//        int ID;
//        String name;
//        while (rs.next()) {
//            ID = rs.getInt("ID");
//            name = rs.getString("CategoryName");
//            categories.add(new Category(ID, name));
//        }
//
//        return categories;
//    }


//    public static Category getCategory(String key) throws Exception {
//
//        Statement stmt = databaseTester.getConnection().getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "select CategoryName FROM Categories WHERE ID=" + key);
//
//        int ID = Integer.parseInt(key);
//        List<Product> products = productDAO.getProductsByCategory(key);
//        String name = "";
//        if (rs.next()) {
//            name = rs.getString("CategoryName");
//        }
//        rs.close();
//        stmt.close();
//        return (new Category(ID, name));
//    }