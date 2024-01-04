package jpql;

import embeddedtype.Address;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    Team team;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name = "COMPANY_CITY")),
            @AttributeOverride(name="street", column=@Column(name = "COMPANY_STREET")),
            @AttributeOverride(name="zipcode", column=@Column(name = "COMPANY_ZIPCODE"))
    })
    Address homeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
