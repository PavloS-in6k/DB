package Entinity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Products", catalog = "Entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "ProductName"),
        @UniqueConstraint(columnNames = "Price"),
        @UniqueConstraint(columnNames = "CategoryID")
})
public class Product {
    private BigDecimal price;
    private String name;
    private int ID;
    private Category category;

    public Product(int ID, BigDecimal price, String name, Category category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    @Column(name = "Price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "ProductName", nullable = false)
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryID(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (ID != product.ID) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + ID;
        return result;
    }
}
