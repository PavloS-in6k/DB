package Entinity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "Orders", catalog = "Entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "TimeStamp"),
        @UniqueConstraint(columnNames = "Price"),
        @UniqueConstraint(columnNames = "UserID")
})
public class Order {
    private int ID;
    private User user;
    private LocalDateTime timeStamp;
    private BigDecimal price;

    public Order(User user, LocalDateTime timeStamp, BigDecimal cost, int ID) {
        this.user = user;
        this.timeStamp = timeStamp;
        this.price = cost;
        this.ID = ID;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
}
