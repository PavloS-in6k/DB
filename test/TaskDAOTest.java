import DAO.CategoryDAOImpl;
import DAO.OrderDAOImpl;
import DAO.Task;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TaskDAOTest {
    private static DB database;
    private static CategoryDAOImpl categoryDAO;
    private static Task task;
    private static OrderDAOImpl orderDAO;

    @BeforeClass
    public static void init() throws Exception {
        database.setUpSessionFactory();

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

    @AfterClass
    public static void cleanUp() throws Exception {
        database.cleanUp();
    }
}