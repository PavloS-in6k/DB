package Entinity;

import javax.persistence.*;

@Entity
public class User {
    private String name;
    private int ID;

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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
