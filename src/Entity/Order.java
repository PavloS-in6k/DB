package Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Orders", catalog = "Entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "UserID"),
        @UniqueConstraint(columnNames = "TimeStamp"),
        @UniqueConstraint(columnNames = "Price")
})
public class Order {
    private int ID;
    private User user;
    private LocalDateTime timeStamp;
    private BigDecimal price;
    private List<Product> products;

    public Order(User user, LocalDateTime timeStamp, BigDecimal cost, int ID) {
        this.user = user;
        this.timeStamp = timeStamp;
        this.price = cost;
        this.ID = ID;
    }

    public Order() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID", nullable = false)
    public User getUser() {
        return user;
    }

    @Column(name = "TimeStamp", nullable = false)
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Column(name = "Price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "OrderProducts",
            joinColumns = {@JoinColumn(name = "OrderID")},
            inverseJoinColumns = {@JoinColumn(name = "ProductID")}
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", user=" + user +
                ", timeStamp=" + timeStamp +
                ", price=" + price +
                ", products=" + products +
                '}';
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Order order = (Order) o;
//
//        if (ID != order.ID) return false;
//        if (user != null ? !user.equals(order.user) : order.user != null) return false;
//        if (timeStamp != null ? !timeStamp.equals(order.timeStamp) : order.timeStamp != null) return false;
//        return price != null ? price.equals(order.price) : order.price == null;
//
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (timeStamp != null ? !timeStamp.equals(order.timeStamp) : order.timeStamp != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        return products != null ? compareProducts(order) : order.products == null;

    }

    protected boolean compareProducts(Order order) {
        return (products.containsAll(order.products) && products.size() == order.products.size());
        //return Arrays.equals(products.toArray(), order.products.toArray());
    }

//    @Override
//    public int hashCode() {
//        int result = ID;
//        result = 31 * result + (user != null ? user.hashCode() : 0);
//        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        return result;
//    }


    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }
}