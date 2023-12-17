# 데이터베이스 방언
- 방언이란 DBMS 마다 가지고있는 SQL 쿼리문법을 의미한다.

&nbps;JPA는 특정 데이터베이스에 종속적이지않고 **Dialect** interface를 활용해 `persistence.xml`파일에 설정되어있는 정보를 토대로 그에 해당하는 SQL쿼리를 작성해준다.

```xml
//persistence.xml예시
<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
```

<br>

![image](https://github.com/oyatrij/my-study/assets/118187065/f6725e76-b8d2-46f5-94ec-578b32fa8fc4)

위 이미지처럼 각인터페이스가 DBMS에 맞는 SQL을 작성해준다.

<br>

# JPA 구동방식

![image](https://github.com/oyatrij/my-study/assets/118187065/6a42bc4c-bf7d-45b2-846f-01cfd67d3d7f)

- `Persistence`로 `EntityManagerFactory`를 생성할 때 `persistence.xml`파일을 참조해 설정정보를 조회한다.
- `EntitymanagerFactory`로 `EntityManager`를 생성하고 트랜젝션을 시작한다.
- `EntitymanagerFactory`는 하나만 생성하여 어플리케이션 전체에서 공유한다.(싱글톤)
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.

<br>

# JPQL

JPA는 엔티티객체를 중심으로 개발된다. 하지만 검색쿼리가 문제다. 모든 데이터를 객체로 변환해서 검색하는것은 불가능하다. 이를 해결하기위해 결국 검색조건이 포함된 SQL이 필요하다. DB 테이블에서 데이터를 가져오면 JPA의 사상이 깨져버린다.
<br>
<br>
JPQL은 객체지향 쿼리언어이다. **객체를 대상으로 쿼리**(DB테이블에 쿼리하는 것이 아니다.)하며 SQL과 문법이 유사하다. 

