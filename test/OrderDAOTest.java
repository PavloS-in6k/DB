import DAO.OrderDAOImpl;
import Entity.Category;
import Entity.Order;
import Entity.Product;
import Entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class OrderDAOTest {
    @Autowired
    OrderDAOImpl orderDAO;

    @Before
    public void setUp() throws Exception {
        DB.setUpDB();
    }

    @Test
    public void getFirstOrder() throws Exception {
        Order bobOrder = new Order(new User(0, "Uncle Bob"), LocalDateTime.parse("2007-07-07T12:00:00"), new BigDecimal("3200.00"), 0);
        Category poverBank = new Category(1, "Power Bank");
        bobOrder.setProducts(asList(
                new Product(1, new BigDecimal("800.00"), "Usual power bank", poverBank),
                new Product(1, new BigDecimal("800.00"), "Usual power bank", poverBank),
                new Product(2, new BigDecimal("20.00"), "sad power bank :(", poverBank)
        ));

        assertThat(orderDAO.getOrderByID(0), equalTo(bobOrder));
    }
}
