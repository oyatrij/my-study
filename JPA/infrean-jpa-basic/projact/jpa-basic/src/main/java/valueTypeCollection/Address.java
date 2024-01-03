package valueTypeCollection;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address() {
    }

    // 임베디드 타입 불변객체 만들기
    // 생성자로 최초 초기화 후 setter 를 제외하여 값을 변경할 수 없게 한다.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }


    public String getStreet() {
        return street;
    }


    public String getZipcode() {
        return zipcode;
    }

}
