import embeddedtype.Address;
import jpql.Member;
import jpql.Team;
import jpql.UserDTO;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpqlTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    public void insertTest() {
        tx.begin();
        Team team = new Team();

        Member member = new Member();
        member.setUsername("회원1");
        member.setAge(19);
        member.setHomeAddress(new Address("서울", "천호대로 39길 46", "123-123"));
        member.setTeam(team);
        em.persist(member);

        tx.commit();
        em.close();
    }

    @Test
    public void jpqlTypequeryTest() {
        //Typequery
        //반환 타입이 명확할 경우 사용해야한다.
        //조회 대상이 Entity일 경우에 사용한다.
        //조회 대상이 String, Integer 등 Entity가 아닐 경우 Query 를 사용해야한다.
        String jpql=  "SELECT m from Member m";
        TypedQuery<Member> query = em.createQuery(jpql, Member.class);
        List<Member> resultList = query.getResultList();

        for (Member member : resultList) {
            System.out.println("username = " + member.getUsername());
            System.out.println("age = " + member.getAge());
        }
    }

    @Test
    public void jpqlQueryTest() {
        //Query
        String jpql=  "SELECT m.username, m.age from Member m";
        List<Object[]> resultList = em.createQuery(jpql).getResultList();

        for (Object o : resultList) {
            Object[] result = (Object[]) o;
            System.out.println("username = " + result[0]);
            System.out.println("age = " + result[1]);
        }
    }

    @Test
    public void namedParamTest() {
        /*
        * 1. Parameter binding
        * 1.1. Named parameters
        *   query 에서 :username 을 작성하고 setParameter("username", usernameParam) 를 통해 :username 에 usernameParam 을 바인딩 한다.
        * */
        String usernameParam = "회원1";
        String query = "SELECT m FROM Member m where m.username = :username";
        List<Member> result = em.createQuery(query, Member.class)
                .setParameter("username", usernameParam)
                .getResultList();
    }

    @Test
    public void entityProjection() {
        String query = "SELECT m.team FROM Member m";
        List result = em.createQuery(query)
                .getResultList();
    }

    @Test
    public void embeddedProjection() {
        String query = "SELECT m.homeAddress FROM Member m";
        List<Address> addresses = em.createQuery(query, Address.class)
                .getResultList();
        for (Address address: addresses) {
            System.out.println("city = " + address.getCity());
            System.out.println("Street = " + address.getStreet());
            System.out.println("zipcode = " + address.getZipcode());
        }
    }

    @Test
    public void beforeNewKeyword() {
        String query = "SELECT m.username, m.age FROM Member m";
        //프로젝션을 엔티티가아닌 여러개의 값으로 조회하게되면 TypedQuery를 사용할 수 없다.
        List<Object[]> resultList = em.createQuery(query)
                .getResultList();

        List<UserDTO> userDTO = new ArrayList<UserDTO>();

        //객체 변환 작업
        for (Object[] o : resultList) {
            UserDTO dto = new UserDTO();
            dto.setUsername((String) o[0]);
            dto.setAge((int) o[1]);
            System.out.println(dto.toString());
            userDTO.add(dto);

        }
    }

    @Test
    public void newKeywordTest(){
        //new 키워드를 사용하여 UserDTO의 생성자로 조회하면 UserDTO 타입으로 TypedQuery를 사용할 수 있다.
        String query = "SELECT new jpql.UserDTO(m.username, m.age) FROM Member m";
        TypedQuery<UserDTO> createQuery = em.createQuery(query, UserDTO.class);
        List<UserDTO> resultList = createQuery.getResultList();
        System.out.println(resultList.toString());
    }
}
