package hellojpa;

import org.hibernate.Transaction;

import javax.persistence.*;

public class ExamMergeMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em1 = emf.createEntityManager();//영속성 컨텍스트 1 생성
        EntityTransaction tx1 =  em1.getTransaction();//트랜잭션 생성
        tx1.begin();//트랜잭션 시작
        Member member = new Member(117L,"member117");//entity 생성
        em1.persist(member);//영속상태
        tx1.commit();//commit
        em1.close();//영속성컨텍스트1 제거, Entity1 준영속상태 진입

        EntityManager em2 = emf.createEntityManager();//영속성 컨텍스트2 생성
        EntityTransaction tx2 = em2.getTransaction();//트랜젝션 생성
        tx2.begin();//트랜젝션 시작
        System.out.println("member merge");
        em2.merge(member);
        System.out.println("1차 캐시 검색");
        Member result = em2.find(Member.class,117L);
        System.out.println("@Id : " + result.getId());
        System.out.println("Name : " + result.getName());
        System.out.println("em2 commit");
        tx2.commit();
        em2.close();
    }
}
