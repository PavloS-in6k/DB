package Entinity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Order> order;
    private int ID;

    public User() {
        order = new ArrayList<>();
    }

    public User(int id, String name) {
        this.ID = id;
        this.name = name;
    }
}
