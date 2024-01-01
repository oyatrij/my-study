import org.junit.jupiter.api.Test;
import transitivePersistence.Child;
import transitivePersistence.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransitivePersistenceTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    public void transitivePersistenceTest() {
        tx.begin();

        Parent parent = new Parent();
        em.persist(parent);

        Child child1 = new Child();
        child1.setParent(parent);
        parent.getChild().add(child1);
        em.persist(child1);

        Child child2 = new Child();
        child2.setParent(parent);
        parent.getChild().add(child2);
        em.persist(child2);

        tx.commit();
        em.close();
    }

    @Test
    public void cascadeTypePersistTest() {
        tx.begin();

        Parent parent = em.find(Parent.class, 4L);

        Child child1 = new Child();
        Child child2 = new Child();

        child1.setParent(parent);
        child2.setParent(parent);
        em.persist(child1);
        em.persist(child2);
        parent.getChild().add(child1);
        parent.getChild().add(child2);

        tx.commit();
        em.close();
    }

    @Test
    public void cascadeRemove() {
        tx.begin();

        Parent findParent = em.find(Parent.class, 1L);
        em.remove(findParent);

        tx.commit();
        em.close();
    }

    @Test
    public void orphanRemovalTest() {

        tx.begin();

        Parent parent = em.find(Parent.class, 4L);

        System.out.println("parent.getChild().size() : " + parent.getChild().size());
        parent.getChild().clear();

        tx.commit();
        em.close();
    }
}
