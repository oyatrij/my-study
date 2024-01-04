import com.mysema.query.jpa.impl.JPAQuery;
import jpql.Member;
import jpql.QMember;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import static jpql.QMember.member;

public class QuerydslTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Test
    public void querydsl() {
        JPAQuery query = new JPAQuery(em);
        List<Member> members =
                query.from(member)
                        .where(member.username.eq("회원1"))
                        .orderBy(member.username.desc())
                        .list(member);
    }

}
