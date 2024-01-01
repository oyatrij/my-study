package transitivePersistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Child> child = new ArrayList<Child>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Child> getChild() {
        return child;
    }

    public void setChild(List<Child> child) {
        this.child = child;
    }
}
