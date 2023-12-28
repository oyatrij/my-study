
import JoinedEntity.Album;
import JoinedEntity.Book;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JoinedTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    @Test
    public void joinedTest () {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Album album = new Album();
        album.setArtist("홍길동");
        album.setName("1집");
        album.setPrice(10000);

        em.persist(album);

        tx.commit();
        em.close();
    }

    @Test
    public void primaryKeyJoinColumn() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Book book = new Book();
        book.setAuthor("작가A");
        book.setISNB("asdfasdf");
        book.setPrice(23000);
        book.setName("가시");

        em.persist(book);

        tx.commit();
        em.close();
    }
}
