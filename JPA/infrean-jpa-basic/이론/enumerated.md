# @Enumerated
`@Enumerated`는 자바의 `enum`타입을 매핑할 때 사용한다.
`@Enumerated`의 속성으로 ORDINAL과 STRING 이 있다. 

```java
//ORDINAL
@Enumerated(EnumType.ORDINAL)
private RoleType roleType;

//STRING
@Enumerated(EnumType.STRING)
private Gender gender;
```

ORDINAL은 enum순서를 데이터베이스에 저장하고 STRING은 enum이름을 데이터베이스에 저장한다.

- ORDINAL
  - 아래 결과처럼 ORDINAL은 enum 데이터의 순서를 DB에 저장한다.
  ```java
  EMember eMemberAdmin = new EMember(1L,RoleType.ADMIN);
  EMember eMemberUser = new EMember(2L,RoleType.USER);

  em.persist(eMemberAdmin);
  em.persist(eMemberUser);
  ```
  ```java    
  public enum RoleType {
    ADMIN, USER;
  }
  ```
  ![image](https://github.com/oyatrij/my-study/assets/118187065/4a7fecb3-48c5-42f1-9264-289ecbf95ce6)
  - 하지만 enum 데이터가 추가되거나 순서가 바뀔 때 치명적인 오류를 발생할 수 있다. 새로 추가한 SUPER를 commit 하니 RoleType에 0이 입력되었다. row1에 입력된 0은 `ADMIN`을 의미하지만 row3의 0은 `SUPER`를 의미한다.

  ```java
  public enum RoleType {
      SUPER, ADMIN, USER; //SUPER 추가
  }
  ```

  ```java
  EMember eMemberSuper = new EMember(3L, RoleType.SUPER);
  em.persist(eMemberSuper);
  ```
  ![image](https://github.com/oyatrij/my-study/assets/118187065/506b5cb8-74f2-4773-9714-4c527074eed6)

  - 이런 오류를 방지하기위해 데이터베이스 공간을 조금 더 사용하더라도 `@Enumerated(EnumType.STRING)`을 사용하는게 좋다.
 
  ![image](https://github.com/oyatrij/my-study/assets/118187065/1d3298ab-a806-496a-9c39-acc4250afcde)

  



