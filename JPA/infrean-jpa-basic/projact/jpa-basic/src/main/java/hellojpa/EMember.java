package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EMember {

    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public EMember(long id, RoleType roleType) {
        this.id = id;
        this.roleType = roleType;
    }
}

