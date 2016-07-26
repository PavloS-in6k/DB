import DAO.CategoryDAOImpl;
import Entinity.Category;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        database.setUpSessionFactory();
        sessionFactory = database.getFactory();
        categoryDAO = new CategoryDAOImpl();
        categoryDAO.setSession(sessionFactory.openSession());
    }

    @Test
    public void getFirstCategory() throws Exception {
        Category testCategory = new Category(0, "Memory Plank");

        assertThat(categoryDAO.getCategory(0), is(equalTo(testCategory)));
    }

    @Test
    public void getCateg() throws Exception {
        Category testCategory = new Category(1, "Power Bank");

        assertThat(categoryDAO.getCategory(1), is(equalTo(testCategory)));
    }

    @Test
    public void getAllCategories() throws Exception {
        List<Category> categories = Arrays.asList(new Category(0, "Memory Plank"),
                new Category(1, "Power Bank"),
                new Category(2, "Tablet"));

        assertThat(categoryDAO.getAllCategories(), equalTo(categories));
    }

    //    @After
//    public void tearDown() throws Exception {
//        database.cleanUp();
//    }
}
