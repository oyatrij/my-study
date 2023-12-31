# 식별관계보다 비식별관게를 지향해야 하는이유

<br>

## 데이터베이스 설계 관점

- 식별관계의 자식과 손자테이블은 PK가 2, 3개로 점점 늘어나고 JOIN 시 SQL이 복잡해지고 index가 불필요하게 커질 수 있다.
- 비지니스 요구사항의 변화에 따른 식별 관계의 자연 키 컬럼들이 자식의 손자까지 이어지면 변경하기 힘들다. (자연키: 실제 비즈니스 도메인에서 발생하는 데이터 값)
- 테이블의 구조가 유연하지 못하다.

<br>

## 객체 관계 매핑 관점

- 식별관계는 2개 이상의 컬럼을 묶은 복합 기본키를 사용한다. 복합키는 별도의 클래스를 만들어서 사용해야하기때문에 컬럼이 하나인 기본키를 매핑하는 것 보다 많은 노력이 필요하다.
- 비식별관계의 PK는 주로 대리키를 이용한다. JPA는 `@GenerateValue` 같은 대리키를 생성하기위한 방법을 제공한다.

<br>

# 선택적 비식별관계 vs 필수적 비식별관계
- 필수적 비식별관계를 사용하는 것이 좋은 이유는 필수적 비식별관계는 NOT NULL 이기때문에 항상관계가 있다는 것을 보장하므로 내부조인만 사용해도 된다. <br>
