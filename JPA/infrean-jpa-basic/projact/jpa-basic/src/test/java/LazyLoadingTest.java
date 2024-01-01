import lazyloading.Member;
import lazyloading.Team;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LazyLoadingTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    public void lazyLoading() {
        tx.begin();

        Team team = new Team();
        em.persist(team);

        Member member = new Member();
        member.setUsername("홍길동");
        member.setAge(20);
        member.setTeam(team);

        em.persist(member);

        tx.commit();
        em.close();
    }

    @Test
    public void findMember() {
        tx.begin();

        Member member = new Member();
        member = em.find(Member.class, 2L);


        em.close();
    }
}
