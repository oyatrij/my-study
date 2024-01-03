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
    public void jpqlTest() {
        String jpql=  "SELECT m.username, m.age from Member m";
        List<Member> resultList = em.createQuery(jpql).getResultList();

        for (Member member : resultList) {
            System.out.println("username = " + member.getUsername());
            System.out.println("age = " + member.getAge());
        }
    }
}
