import DAO.OrderDAOImpl;
import DAO.UserDAOImpl;
import Entinity.Order;
import Entinity.User;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class OrderDAOTest {
    OrderDAOImpl orderDAO = new OrderDAOImpl();

    @Before
    public void setUp() throws Exception {
        orderDAO.setConnectionFactory(DB.getConnectionFactory());
    }

    @Test
    public void getFirstOrder() throws Exception {
        Order testOrder = new Order(new User(0, "Uncle Bob"), LocalDateTime.parse("2007-07-07T12:00:00"), new BigDecimal("3200.00"), 0);

        assertThat(orderDAO.getOrderByID(0), equalTo(testOrder));
    }
}
