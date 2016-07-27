import DAO.CategoryDAOImpl;
import Entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class CategoryDAOTest {
    @Autowired
    private CategoryDAOImpl categoryDAO;

    @Before
    public void setUp() throws Exception {
        DB.setUpDB();
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
