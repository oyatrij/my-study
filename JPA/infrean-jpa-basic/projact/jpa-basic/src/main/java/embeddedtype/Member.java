package embeddedtype;

import javax.persistence.*;

//@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded Period workPeriod;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="city", column=@Column(name = "COMPANY_CITY")),
        @AttributeOverride(name="street", column=@Column(name = "COMPANY_STREET")),
        @AttributeOverride(name="zipcode", column=@Column(name = "COMPANY_ZIPCODE"))
    })
    Address homeAddress;

    @Embedded PhoneNumber phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
