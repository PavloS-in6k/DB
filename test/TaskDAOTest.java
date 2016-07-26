import DAO.TaskDAO;
import Entinity.Category;
import Entinity.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class TaskDAOTest {
    TaskDAO taskDAO = new TaskDAO();

    @Before
    public void init() throws Exception {
        taskDAO.setConnectionFactory(DB.getConnectionFactory());
    }

    @Test
    public void getCategoriesWithCounts() throws Exception {
        Category memory = new Category(0, "Memory Plank");
        memory.setProductsCount(2);
        Category powerBank = new Category(1, "Power Bank");
        powerBank.setProductsCount(3);
        Category tablet = new Category(2, "Tablet");
        tablet.setProductsCount(1);

        assertThat(taskDAO.getAllCategoriesWithNumbers(), contains(memory, powerBank, tablet));
    }

    @Test
    public void getAllItemsForOrderID() throws Exception {
        /*
       <OrderProducts ID="0" OrderID="0" ProductID="1"/>
       <OrderProducts ID="1" OrderID="0" ProductID="1"/>

       <Products ID="1" ProductName="Usual power bank" Price="800.00" CategoryID="1"/>

       <OrderProducts ID="2" OrderID="0" ProductID="2"/>

       <Products ID="2" ProductName="sad power bank :(" Price="20.00" CategoryID="1"/>
         */
        List<Product> productsForID0 = Arrays.asList(
                new Product(1, new BigDecimal("800.00"), "Usual power bank", new Category(1, "Power Bank")),
                new Product(1, new BigDecimal("800.00"), "Usual power bank", new Category(1, "Power Bank")),
                new Product(2, new BigDecimal("20.00"), "sad power bank :(", new Category(1, "Power Bank"))
        );

        assertThat(taskDAO.getAllItemsForOrderID(0), contains(productsForID0));
    }
}

//
//    @Test
//    public void testCategoryOrder() throws Exception {
//        assertEquals(categoryDAO.getAllCategories().size(), 3);
//        assertEquals(categoryDAO.getAllCategories().get(0).getProducts().size(), 2);
//        assertEquals(categoryDAO.getAllCategories().get(1).getProducts().size(), 3);
//        assertEquals(categoryDAO.getAllCategories().get(2).getProducts().size(), 1);
//    }
//
//    @Test
//    public void isAllProductsForCategoryGivenBackCorrect() throws Exception {
//        Category testSample = new Category(2, "Tablet", Collections.singletonList(new Product(5, BigDecimal.valueOf(350.00), "Tabletko", 2)));
//        Category gettedSample = categoryDAO.getCategory("2");
//
//        assertEquals(gettedSample.getName(), testSample.getName());
//        assertThat(gettedSample.getProducts().size(), equalTo(1));
//        assertThat(gettedSample.getProducts().get(0).getName(), equalTo(testSample.getProducts().get(0).getName()));
//
//    }
//
//    @Test
//    public void isAllCategoriesGivenBack() throws Exception {
//        Category testMemoryPlank = new Category(0, "Memory Plank", Arrays.asList(
//                new Product(3, BigDecimal.valueOf(9000.01), "Memory XDDR 1337GHz", 0),
//                new Product(4, BigDecimal.valueOf(900.00), "Memory NOXDDR 619MHz", 0)
//        ));
//        Category testPowerBank = new Category(1, "Power Bank", Arrays.asList(
//                new Product(0, BigDecimal.valueOf(1200.00), "MEGAPOWERBANK!!111", 1),
//                new Product(1, BigDecimal.valueOf(800.00), "Usual power bank", 1),
//                new Product(2, BigDecimal.valueOf(20.00), "sad power bank :(", 1)
//        ));
//        Category testTablets = new Category(2, "Tablet", Collections.singletonList(new Product(5, BigDecimal.valueOf(350.00), "Tabletko", 2)));
//
//
//        List<Category> values = categoryDAO.getAllCategories();
//        //assertThat(values, hasItems(Arrays.asList(testMemoryPlank, testPowerBank, testTablets)));
//    }
//
//    @Test
//    public void getOrderByID() throws Exception {
//        List<Product> products = Arrays.asList(new Product(0, BigDecimal.valueOf(1200.00), "MEGAPOWERBANK!!111", 1),
//                new Product(0, BigDecimal.valueOf(1200.00), "MEGAPOWERBANK!!111", 1),
//                new Product(1, BigDecimal.valueOf(800.00), "Usual power bank", 1));
//
//        Order order = orderDAO.getOrderByID(String.valueOf(0));
//
//        assertEquals(orderDAO.getOrderProducts("0").size(), products.size());
//        assertEquals(order.getTimeStamp(), LocalDateTime.parse("2007-07-07T12:00:00"));
//        // нaйти спосо6 срaвнить
//        // assertEquals(order.getPrice(), testOrder.getPrice());
//    }
//
//    @Test
//    public void getTop3() throws Exception {
//        List<ItemCount> top3 = task.getTop3("Power Bank");
//        List<ItemCount> testTop = Arrays.asList(new ItemCount("MEGAPOWERBANK!!111", 2), new ItemCount("Usual power bank", 1));
//
//        assertEquals(top3.size(), 3);
//        assertEquals(top3.get(0).getName(), "MEGAPOWERBANK!!111");
//    }
//
//    @AfterClass
//    public static void cleanUp() throws Exception {
//        database.cleanUp();
//    }