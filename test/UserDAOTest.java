import DAO.UserDAOImpl;
import Entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class UserDAOTest {
    @Autowired
    UserDAOImpl userDAO;

    @Before
    public void setUp() throws Exception {
        DB.setUpDB();
    }

    @Test
    public void getFirstUser() throws Exception {
        User testUser = new User(0, "Uncle Bob");

        assertThat(userDAO.getUserByID(0), equalTo(testUser));
    }
}
