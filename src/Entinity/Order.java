package Entinity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private User user;
    private LocalDateTime timeStamp;
    private List<Product> products;
    private BigDecimal price;

    public Order(User user, LocalDateTime timeStamp, List<Product> products, BigDecimal cost) {
        this.user = user;
        this.timeStamp = timeStamp;
        this.products = products;
        this.price = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
