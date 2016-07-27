package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Categories", catalog = "Entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "CategoryName")
})
public class Category {
    private int ID;
    private String name;
    private Integer productsCount;

    public Category() {
    }

    public Category(String name, int ID, long productsCount) {
        this.productsCount = Integer.valueOf(String.valueOf(productsCount));
        this.name = name;
        this.ID = ID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    @Column(name = "CategoryName", nullable = false)
    public String getName() {
        return name;
    }

    public Category(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Transient
    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", productsCount=" + productsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (productsCount != category.productsCount) return false;
        return name != null ? name.equals(category.name) : category.name == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
