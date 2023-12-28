import embeddedIdEntity.Parent;
import embeddedIdEntity.ParentId;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

public class EmbeddedIdTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    @Test
    void embeddedIdTest() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Parent parent = new Parent();
        ParentId parentId = new ParentId("id1","id2");
        parent.setId(parentId);
        parent.setName("test");
        em.persist(parent);

        tx.commit();
        em.close();
    }
    @Test
    void findEmbeddedIdTest() {
        EntityTransaction tx = em.getTransaction();

        Parent parent = new Parent();
        ParentId parentId = new ParentId("id1", "id2");
        parent = em.find(Parent.class, parentId);
        System.out.println(parent.toString());

        em.close();
    }
}
