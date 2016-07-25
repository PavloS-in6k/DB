package Entinity;

import javax.persistence.*;

@Entity
@Table(name = "Category", catalog = "Entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "CategoryName")
})
public class Category {
    private int ID;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    @Column(name = "CategoryName", nullable = false)
    public String getName() {
        return name;
    }

    public Category(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

}
