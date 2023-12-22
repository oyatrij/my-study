package hellojpa;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamEnumeratedTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    @Transactional
    public void enumTest() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        EMember eMemberSuper = new EMember(1L, RoleType.SUPER);
        EMember eMemberAdmin = new EMember(2L, RoleType.ADMIN);
        EMember eMemberUser = new EMember(3L, RoleType.USER);
        em.persist(eMemberSuper);
        em.persist(eMemberAdmin);
        em.persist(eMemberUser);

        tx.commit();
        em.close();
    }

    @Test
    @Transactional
    public void testSave() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();

        //팀1 저장
        Team team1 = new Team("team1","팀1");
        em.persist(team1);

        //회원A 저장
        Member memberA = new Member(1L, "A");
        memberA.setTeam(team1);
        em.persist(memberA);

        //회원B 저장
        Member memberB = new Member(2L, "B");
        memberB.setTeam(team1);
        em.persist(memberB);

        tx.commit();
        em.close();
    }

    @Test
    @Transactional
    public void testPureObject() {

        tx.begin();

        //팀1
        Team team1 = new Team("tea1","팀1");
        Team team2 = new Team("team2","팀2");
        em.persist(team1);

        Member memberA = new Member(1L,"A");
        Member memberB = new Member(2L,"B");

        memberA.setTeam(team1);
        memberB.setTeam(team1);
        memberA.setTeam(team2);

        List<Member> findMember = team1.getMembers();
        for (Member member: findMember) {
            System.out.println(member.getUsername());
        }
        //Member entity의 리팩토링으로 밑 코드는 삭제한다.
        //team1.getMembers().add(memberA);
        //team1.getMembers().add(memberB);
/*
        em.persist(memberA);
        em.persist(memberB);

        tx.commit();
        em.close();*/
    }
}