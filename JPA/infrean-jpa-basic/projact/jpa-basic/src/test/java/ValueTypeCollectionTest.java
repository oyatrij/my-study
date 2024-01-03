import org.junit.jupiter.api.Test;
import valueTypeCollection.Address;
import valueTypeCollection.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ValueTypeCollectionTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    public void valueTypeCollectionTest() {
        tx.begin();

        Member member = new Member();

        //임베디드 값 타입 setting
        member.sethomeAddress(new Address("통영","몽돌해수욕장","660-123"));

        //기본값 타입 컬렉션
        member.getFavoriteFoods().add("짬뽕");
        member.getFavoriteFoods().add("짜장");
        member.getFavoriteFoods().add("탕수육");

        //임베디드 값 타입 컬렉션
        member.getAddressHistory().add(new Address("서울","강남","123-123"));
        member.getAddressHistory().add(new Address("서울","강북","000-000"));

        em.persist(member);
        tx.commit();
        em.close();
    }
}
