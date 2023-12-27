import entity.Member;
import entity.Team;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MappingTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    @Test
    public void oneToManyTest() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        Team team1 = new Team("Team1");


        em.persist(member1);//INSERT member1
        em.persist(member2);//INSERT member2
        em.persist(team1);  //INSERT team1
                            //UPDATE member1 FK, UPDATE member2 FK
                            //UPDATE 추가 발생
        tx.commit();
    }
}
