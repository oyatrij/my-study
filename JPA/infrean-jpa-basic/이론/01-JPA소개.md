<br>

>Infrean 김영한님의 **자바 ORM 표준 JPA 프로그래밍 - 기본편**을 감상하며 작성하였습니다.

<br>

# 목차
1. [JPA](#jpa-java-persistence-api)
2. [왜 JPA를 사용해야할까](#왜-jpa를-사용해야할까)

# JPA (Java Persistence API)
- 자바 진영의 **ORM** 기술 표준
- ORM (Object Relational Mapping, 객체관계매핑)
  - 객체는 객체대로 생성하고 관계형DB는 DB 대로 설계
  - ORM 프레임워크가 중간에서 매핑
- Java application과 JDBC 사이에서 동작<br><br>
  ![image](https://github.com/oyatrij/my-study/blob/main/JPA/infrean-jpa-basic/assets/javaApplicationToJDBC.png)
- JPA는 표준명세이며 interface모음이다.
  - 구현체에는 Hibernate, EclipseLink, DataBucleus 가 있으며 보통 Hibernate를 많이 쓴다.<br><br>
  ![image](https://github.com/oyatrij/my-study/blob/main/JPA/infrean-jpa-basic/assets/JpaInterface.png)

---

<br>

# 왜 JPA를 사용해야할까
- 생산성
  - SQL 쿼리를 반복해서 사용하지 않아도 된다.
  - 저장, 조회, 수정, 삭제가 어떻게 사용되는지 보면<br>
  
    ```java
    jpa.persist(member) //저장
    Member member = jpa.jind(memberId) //조회
    member.setName("변경할 이름") //수정
    jpa.remove(member) //삭제
    ```
    
- 유지보수
  - 기존 mybatis에서는 SQL을 직접 컨트롤 해야했다. 즉, 개발자가 mapper였다.<br>
    의 필드가 변경되었다고 가정하면 해당 테이블을 사용하고있는 SQL을 모두 변경해야한다.<br>
    `TEL`필드가 추가되었다고 한다면 SQL에 `TEL` 이 들어가는 부분을 모두 추가해야한다.<br>
    ```SQL
    INSERT INTO MEMBER(MEMBER_ID, NAME, TEL) VALUES
    SELECT MEMBER_ID, NAME, TEL FROM MEMBER M
    UPDATE MEMBER SET ... TEL = ?
    ```
    JPA를 사용하면 Member 객체에 멤버변수만 추가해주면 된다.
    
    ```java
    public class Member {
      private String memberId;
      private String name;
      private Stirng tel;//추가부분
    }
    ```
    
- 패러다임 불일치 해결
  - 상속<br>
    ![image](https://github.com/oyatrij/my-study/blob/main/JPA/infrean-jpa-basic/assets/objectExtend.png)<br>
    - 객체에서의 상속관계를 SQL로 풀어내려면 복잡한 SQL을 작성하거나 반복하여 작성해야한다.<br>
      하지만 JPA를 활용하면 이를 편리하게 객체의 상속관계를 풀어낼 수 있다.
    - 저장<br>
      album 객체를 관계형DB에 저장하기 위해서는 ITEM 테이블에 insert 해줘야하고,<br>
      insert한 row의 item_id를 활용하여 ALBUM 테이블에 insert 해줘야한다.<br>
      하지만 JPA에서는 개발자가 jpa.persist(album); 한 줄만 코딩하면된다.<br>
      나머지는 JPA가 두 줄의 sql을 만들고 처리해준다.
    - 조회<br>
      그렇다면 조회는 어떻게 할까?<br>
      SQL에서는 JOIN을 활용하여 처리해야한다.<br>
      ```sql
      SELECT I.*, A.*
      FROM ITEM I
      JOIN ALBUM A ON I.ITEM_ID = A.ITEM_ID
      ```
      JPA는 `find`를 통해 조회할 수 있다.
      ```java
      Album album = jpa.find(Album.class, albumId);
      ```
  - 연관관계<br>
  - 객체 그래프 탐색
  - 비교<br>
    ```java
    String memberId = "100";
    Member member1 = jpa.find(Member.class, memberId);
    Member member2 = jpa.find(Member.class, memberId);

    member1 == member2; //같다.
    ```
    위 코드는 참조형변수안에 있는 메모리주소를 비교하는 연산자 `==`를 사용했지만<br>
    JPA에서는 해당 변수가가리키고있는 메모리주소의 값을 비교해준다.
- 성능 최적화 기능
  - 1차 캐시와 동일성(identity) 보장
  - 트랜잭션을 지원하는 쓰기 지연(Transactional write-behind)
  - 지연로딩(Lazy Loading)
- 데이터 접근 추상화와 벤더 독립성
- 표준
    


