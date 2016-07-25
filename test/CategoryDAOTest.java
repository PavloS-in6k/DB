import DAO.CategoryDAOImpl;
import Entinity.Category;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryDAOTest {
    private CategoryDAOImpl categoryDAO;
    private SessionFactory sessionFactory;
    private DB database;

    @Before
    public void setUp() throws Exception {
        database = new DB();
        database.setUpSessionFactory();
        database.setUpDB();
        sessionFactory = database.getFactory();
        categoryDAO = new CategoryDAOImpl();
        categoryDAO.setSession(sessionFactory.openSession());
    }

    @Test
    public void getFirstCategory() throws Exception {
        Category testCategory = new Category(0,"Memory Plank");


    }

    @After
    public void tearDown() throws Exception {
        database.cleanUp();
    }
}
