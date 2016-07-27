package Entinity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void productsEquality() throws Exception {
        Product productA = new Product(0, new BigDecimal("1200.00"), "MEGAPOWERBANK!!111", new Category(1, "Power Bank"));
        Product productB = new Product(0, new BigDecimal("1200.00"), "MEGAPOWERBANK!!111", new Category(1, "Power Bank"));

        assertThat(productA, equalTo(productB));
    }
}