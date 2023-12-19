# 병합: merge()

`merge()`는 준영속 상태의 엔티티를 파라미터로 받아 새로운 영속 상태의 엔티티를 반환한다.

```java
//merge() 메소드 정의
public <T> merge(T entity);
```

`merge()`의 과정을 도식화 하면

![image](https://github.com/oyatrij/my-study/assets/118187065/0520e9eb-c556-4966-94b8-e473905be1e8)

1. `merge()`실행
2. `merge()`가 실행되면 1차캐시에서 `@Id`값에 해당하는 entity가 있는 확인한다.
  1. 1차캐시에 해당 @Id값이 부재 시 DB에서 조회한다.
3. 병합하여 entity를 영속상태로 만든다.
4. 영속상태의 entity를 반환한다.

코드로 확인해 보자.

```java
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
        System.out.println("em2 commit");
        tx2.commit();
        em2.close();
    }
```
위 코드를 실행하면 아래 결과가 출력된다.

![image](https://github.com/oyatrij/my-study/assets/118187065/c02b9132-fa3d-4ef7-bf81-44fd79f04048)

출력한 `memeber merge` 이후 출력된 결과를 보면 1차캐시에 해당 `@Id`값이 부재하여 DB에서 조회하는 것을 확인할 수 있다.<br>
이제 1차캐시에는 `@Id`값이 117인 entity 데이터가 삽입되어 있을 것이다.

```java
System.out.println("1차 캐시 검색");
Member result = em2.find(Member.class,117L);
System.out.println("@Id : " + result.getId());
```

결과

![image](https://github.com/oyatrij/my-study/assets/118187065/15002d4f-5335-4667-8245-2ed5cd1ebcef)


