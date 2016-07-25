import DAO.CategoryDAOImpl;
import Entinity.Category;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryDAOTest {
    private CategoryDAOImpl categoryDAO;
    private SessionFactory sessionFactory;
    private DB database;

    @Before
    public void setUp() throws Exception {
        database = new DB();
        database.setUpDB();
        database.setUpSessionFactory();
        sessionFactory = database.getFactory();
        categoryDAO = new CategoryDAOImpl();
        categoryDAO.setSession(sessionFactory.openSession());
    }

    @Test
    public void getFirstCategory() throws Exception {
        Category testCategory = new Category(0,"Memory Plank");

        assertThat(categoryDAO.getCategory(0), is(equalTo(testCategory)));
    }

    @Test
    public void getCateg() throws Exception {
        Category testCategory = new Category(1,"Power Bank");

        assertThat(categoryDAO.getCategory(1), is(equalTo(testCategory)));
    }

    @After
    public void tearDown() throws Exception {
        database.cleanUp();
    }
}
