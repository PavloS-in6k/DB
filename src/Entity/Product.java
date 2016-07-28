package Entity;

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

    public Product() {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoryID", nullable = false)
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

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", ID=" + ID +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return category != null ? category.equals(product.category) : product.category == null;

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + ID;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
