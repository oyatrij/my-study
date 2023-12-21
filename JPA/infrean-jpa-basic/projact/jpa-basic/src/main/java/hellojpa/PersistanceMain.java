package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistanceMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            /*
            member.setId(101L);
            member.setName("HelloJPA");


            //영속
            System.out.println("===BEFORE===");
            //1차 캐시에 저장
            em.persist(member);
            System.out.println("===AFTER===");
*/

            //영속성 컨텍스트 안에 있기 때문에 DB를 조회하지않는다.
            //Member findMember1 = em.find(Member.class,101L);
            //Member findMember2 = em.find(Member.class,101L);
            /*
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
*/
            /*Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);*/

            System.out.println("==========");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

    }
}
