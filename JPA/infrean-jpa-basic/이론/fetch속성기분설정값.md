# fetch 속성 기본설정 값
- 엔티티가 하나면 즉시로딩, 컬렉션이면 지연로딩
- @ManyToOne, @OneToOne: 즉시로딩(FetchType.EAGER)
- @OneToMany, @ManyToMany: 지연로딩(FetchType.LAZY)

모든 연관관계에서 지연 로딩 사용을 추천한다.<br>
어플리케이션 개발이 어느 정도 완료되면 필요한 곳에 즉시로딩을 적용하며 최적화한다.<br>
<br>

JPA를 사용하지않고 SQL을 직접사용하게되면 이런 유연한 최적화가 어렵다.<br>
SQL로 작성 후 최적화를 하려면 여러곳에서 많은 SQL을 수정해야한다.<br>



