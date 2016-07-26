import DAO.UserDAOImpl;
import Entinity.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDAOTest {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Before
    public void setUp() throws Exception {
        userDAO.setConnectionFactory(DB.getConnectionFactory());
    }

    @Test
    public void getFirstUser() throws Exception {
        User testUser = new User(0, "Uncle Bob");

        assertThat(userDAO.getUserByID(0), equalTo(testUser));
    }
}
