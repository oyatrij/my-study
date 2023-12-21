package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMain {
    //영속성 컨텍스트 update
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member = em.find(Member.class,2L);
            //1차캐시에 있는 내용을 변겨만 해주었다.

            //1차캐시에 있기 때문에 다시 넣을 필요가없다.
            //em.persist(member);

            System.out.println("=============");

            tx.commit();

        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
