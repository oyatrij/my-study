import entity.Member;
import entity.Product;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MappingTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    @Test
    public void oneToManyTest() {
        /*EntityManager em = emf.createEntityManager();
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
        tx.commit();*/
    }

    @Test
    public void manyToManyTest() {
        tx.begin();

        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Product productB = new Product();
        productB.setId("productB");
        productB.setName("상품B");
        em.persist(productB);

        Product productC = new Product();
        productC.setId("productC");
        productC.setName("상품C");
        em.persist(productC);

        Member member1 = new Member("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);
        member1.getProducts().add(productB);
        member1.getProducts().add(productC);

        em.persist(member1);

        tx.commit();
        em.close();
    }

    @Test
    public void find() {
        tx.begin();

        Member member = em.find(Member.class,"member1");
        System.out.println("sql시작");
        List<Product> products = member.getProducts();
        for (Product product : products) {
            System.out.println("product.name = " + product.getName());
        }

        tx.commit();

    }

    @Test
    public void manyToManyBothTest() {
        tx.begin();

        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member member1 = new Member("member1");
        member1.setUsername("회원1");
        member1.addProduct(productA);
        em.persist(member1);

        findInverse();

        tx.commit();
        em.close();
    }

    public void findInverse() {
        Product product = em.find(Product.class,"productA");
        List<Member> members = product.getMember();
        for (Member member: members) {
            System.out.println("member = " + member.getUsername());
        }
    }
}
