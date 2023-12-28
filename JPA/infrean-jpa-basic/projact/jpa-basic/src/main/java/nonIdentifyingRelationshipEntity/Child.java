package nonIdentifyingRelationshipEntity;

import javax.persistence.*;

//@Entity
public class Child {
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "PARENT_ID1"),
        @JoinColumn(name = "PARENT_ID2")
    })
    private Parent parent;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
