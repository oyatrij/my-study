package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id @Column(name = "MEMBER_ID")
    private String id;
    private String username;
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProductId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<MemberProduct> getMemberProductId() {
        return memberProductId;
    }

    public void setMemberProductId(List<MemberProduct> memberProductId) {
        this.memberProductId = memberProductId;
    }
}
