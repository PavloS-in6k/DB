package Entinity;

import java.util.List;

public class Category {
    private List<Product> products;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    private String name;

    public Category(int ID, String name, List<Product> products) {
        this.ID = ID;
        this.name = name;
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {

        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (ID != category.ID) return false;
        if (products != null ? !products.equals(category.products) : category.products != null) return false;
        return name != null ? name.equals(category.name) : category.name == null;

    }

    @Override
    public int hashCode() {
        int result = products != null ? products.hashCode() : 0;
        result = 31 * result + ID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
