import jpql.Member;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpqlTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    public void insertTest() {
        tx.begin();

        Member member = new Member();
        member.setUsername("회원1");
        member.setAge(19);
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
        Query query = em.createQuery(jpql);
        List resultList = query.getResultList();

        for (Object o : resultList) {
            Object[] result = (Object[]) o;
            System.out.println("username = " + result[0]);
            System.out.println("age = " + result[1]);
        }
    }
}
