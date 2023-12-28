import nonIdentifyingRelationshipEntity.Child;
import nonIdentifyingRelationshipEntity.Parent;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class IdClassTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    @Test
    void idClassTest() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");
        parent.setName("parentName");
        em.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        em.persist(child);

        tx.commit();
        em.close();
    }
}
