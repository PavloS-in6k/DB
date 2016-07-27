package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users", catalog = "Entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "UserName")
})
public class User {
    private String name;
    private int ID;
    private List<Order> orders;

    public User() {
    }

    public User(int id, String name) {
        this.ID = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    @Column(name = "UserName", nullable = false)
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (ID != user.ID) return false;
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//        return orders != null ? isOrdersEquals(user) : user.orders == null;
//
//    }
//
//    protected boolean isOrdersEquals(User user) {
//        return (user.orders.size() == orders.size() && orders.containsAll(user.orders));
//        //return orders.equals(user.orders);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + ID;
        return result;
    }
}
