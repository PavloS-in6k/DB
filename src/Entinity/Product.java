package Entinity;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;
    private String name;
    private int ID;
    private int categoryID;

    public Product(int ID, BigDecimal price, String name, int categoryID) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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
