import DAO.ProductDAOImpl;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
    private IDatabaseTester databaseTester;
    private SessionFactory factory;

    public void setUpSessionFactory() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void setUpDB() throws Exception {
        databaseTester = new JdbcDatabaseTester(org.hsqldb.jdbcDriver.class
                .getName(), "jdbc:hsqldb:file:~Desktop/si", "sa", "");
        createTablesSinceDbUnitDoesNot(databaseTester.getConnection().getConnection());
        String inputXml = getStringDBfromXml();
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new StringReader(inputXml));
        databaseTester.setDataSet(dataSet);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
        databaseTester.onSetup();


        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO.setConnection(databaseTester);
    }


    private void createTablesSinceDbUnitDoesNot(Connection connection)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE Categories" +
                "(ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, CategoryName VARCHAR(255))");
        statement.execute();
        statement.close();

        statement = connection.prepareStatement("CREATE TABLE Products" +
                "(ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, ProductName VARCHAR(255), " +
                "Price DECIMAL, CategoryID INT, FOREIGN KEY(CategoryID) REFERENCES Categories(ID))");
        statement.execute();
        statement.close();

        statement = connection.prepareStatement("CREATE TABLE Users" +
                "(ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, UserName VARCHAR(255))");
        statement.execute();
        statement.close();

        statement = connection.prepareStatement("CREATE TABLE Orders" +
                "(ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, TimeStamp TIMESTAMP , Price DECIMAL, " +
                "UserID INT, FOREIGN KEY(UserID) REFERENCES Users(ID))");
        statement.execute();
        statement.close();

        statement = connection.prepareStatement("CREATE TABLE OrderProducts" +
                "(OrderID INT, ProductID INT, " +
                "ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, " +
                "FOREIGN KEY(OrderID) REFERENCES Orders(ID), " +
                "FOREIGN KEY(ProductID) REFERENCES Products(ID))");
        statement.execute();
        statement.close();
    }


    protected String getStringDBfromXml() throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;

        Document doc = getXml();
        transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.getBuffer().toString();
    }

    private Document getXml() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("test/DB.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        return doc;
    }

    public void cleanUp() throws Exception {
        databaseTester.onTearDown();
        databaseTester = null;
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
