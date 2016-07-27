import DAO.ProductDAOImpl;
import Entity.Category;
import Entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class ProductDAOTest {
    @Autowired
    ProductDAOImpl productDAO;

    @Before
    public void setUp() throws Exception {
        DB.setUpDB();
    }

    @Test
    public void getFirstProduct() throws Exception {
        Product testProduct = new Product(0, new BigDecimal("1200.00"), "MEGAPOWERBANK!!111", new Category(1, "Power Bank"));

        assertThat(productDAO.getProduct(0), equalTo(testProduct));
    }

    @Test
    public void getThirdProduct() throws Exception {
        Product testProduct = new Product(2, new BigDecimal("20.00"), "sad power bank :(", new Category(1, "Power Bank"));

        assertThat(productDAO.getProduct(2), equalTo(testProduct));
    }

    @Test
    public void getFifthProduct() throws Exception {
        Product testProduct = new Product(4, new BigDecimal("900.00"), "Memory NOXDDR 619MHz", new Category(0, "Memory Plank"));

        assertThat(productDAO.getProduct(4), equalTo(testProduct));
    }
}