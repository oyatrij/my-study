# 영속성 컨텍스트와 JPQL
JPQL의 조회대상에는 3가지가 있다.
  - 엔티티
  - 임베디드 타입
  - 값 타입
위 세 가지타입에서 엔티티를 조회하였을 때만 영속성 컨텍스트에서 관리한다.

```sql
select m from Member m //관리O
select o.address from Order o //관리x
select m.id, m.username from Member m //관리x
```

# 영속성 컨텍스트와 엔티티
조회대상이 엔티티일 경우에만 영속성컨텍스트에서 관리한다고 했다.<br>
그럼 영속성 컨텍스트에 `회원1`이 존재할 때 JPQL로 `회원1`을 다시 조회하면 어떻게 될까?<br>

1. JPQL 조회 요청
2. SQL로 변환 후 DB에서 조회
3. 조회한 결과값을 식별자 기준(@ID)으로 비교
4. 이미 값이 있으면 `DB에서 조회한 데이터` 폐기 후 영속성 컨텍스트에 있는 기존 데이터 return
5. 없으면 영속성 컨텍스트에 추가

중요한 사실은 두 가지이다.
-  JPQL로 조회한 엔티티는 영속상태이다.
-  영속성 컨텍스트에 이미 존재하는 엔티티가 있으면 기존 엔티티를 반환한다.

내 생각으로는 JPQL로 조회한 엔티티로 교체될 줄 알았는데 아니었다.<br>
왜 JPQL로 조회한 인티티로 교체되면 안될까?<br>
<br>

새로운 엔티티로 교체하게되면 기존에 수정중인 데이터가 사라질 수 있기 때문이다.

# find() vs JPQL
- em.find()
  - 영속성컨텍스트를 먼저 검색하고 없으면 DB에서 조회한다.
  - 영속성컨텍스트에 있으면 메모리에서 검색하기 때문에 성능상 이점이 있다.(1차 캐시)
- JQPL
  - 영속석 컨텍스트에 값이 있든 없든 항상 DB에서 조회한다.

# JPQL과 flush
[영속성 컨텍스트와 엔티티](#영속성-컨텍스트와-엔티티)에서 기존데이터를 새로운 엔티티로 교체하면 안되는 이유를 알아보았다.<br>
이 문제를 해결하기위해 영속성컨텍스트에 플러시 모드를 설정할 수 있다.<br>

```java
em.setFlushMode(FlushModeType.AUTO); //쿼리 실행 직전에 영속성컨텍스트 플러시 (기본값)
em.setFlushMode(FlushModeType.COMMIT); //커밋시에만 플러시
```

```java
em.setFlushMode(FlushModeType.COMMIT); // 커밋시에만 플러시

product.setPrice(2000);

//가격이 2000원인 상품 조회
Product product2 =
  em.createQuery("select p form Product p where p.price = 2000", product.class)
    .setFlushMode(FlushModeType.AUTO) //setFlushMode() 설정
    .getSingleResult();
```

위 코드에서 JPQL 에서 설정한 `AUTO`가 `em.setFlushMode(FlushModeType.COMMIT);` 보다 우선권을 가진다.<br>
따라서 `getSingleResult();`로 쿼리하기 전에 플러시가 발생한다.<br>

<br>

플러시 모드의 기본값은 `AUTO`이다. 따라서 우리가 우려했던 JQPL 쿼리결과와 영속성컨텍스트의 데이터가 불일치하는 일을 방지할 수 있다.<br>
그렇다면 왜 `COMMIT` 모드가 있는 걸까?<br>
아래는 플러시모드를 `AUTO`로 설정했을 때 발생하는 플러시 횟수이다.

```
//비지니스로직
등록()
쿼리()//플러시
등록()
쿼리()//플러시
등록()
쿼리()//플러시
커밋()//플러시
```

총 4번의 플러시가 발생한다.<br>
하지만 플러시모드가 `COMMIT` 이라면 모든 커밋()시에만 플러시가 한 번 발생한다.<br>




