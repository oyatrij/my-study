### SOLID 란?
객체지향에 꼭 지켜야 할 5개의 원칙입니다.
- SRP(Single Responsibility Principle) : 단일 책임 원칙 - 객체는 오직 하나의 책임을 가져야 한다는 뜻으로 클래스의 목적을 명확히 함으로써 수정사항이 불필요하게 넓게 퍼지는 것을 예방하고 기능을 명확히 분리할 수 있게 합니다.
- OCP(Open-Closed Principle) : 개방-패쇄 원칙 - 객체는 확장에 대해서는 개방적이고 수정에 대해서는 폐쇄적이어야 한다는 원칙입니다. 기능 추가를 할때는 기존 클래스를 손대지않고 새로 클래스를 생성하여 추가해야합니다. 
- LSP(Liskov Substitution Principle : 리스코프 치환 원칙 - 자식 클래스는 언제나 자신의 부모 클래스를 대체할 수 있다는 원칙입니다. 부모클래스가 들어갈 자리에 자식 클래스를 넣어도 잘 작동해야 상속을 본질을 잘 지킨 것 입니다. 이를 지키지 않으면 부모 클래스 본래의 의미가 변해 다형성을 지킬 수 없게 됩니다.
- ISP(Interface Segregation Principle) : 인터페이스 분리 원칙 - 클라이언트에서 사용하지 않는 메서드는 사용하면 안된다는 원칙입니다. 사용하지 않는 메서드가 있으면 인터페이스를 더 작게 나누어 만들어야 합니다.
- DIP(Dependency Inversion Principle(DIP) : 의존성 역전 원칙 - 어떤 클래스를 참조해서 사용해야 한다면 직접 그 클래스를 참조하는 것이 아닌 그 클래스의 상위 요소인 추상클래스나 인터페이스로 참조해야 한다는 원칙입니다.
<br><br>

## 1. 생성 패턴
### 싱글톤
- 특정 클래스에 객체 인스턴스가 하나만 만들어지도록 해주는 패턴입니다. 싱글턴 패턴을 사용하면 객체 인스턴스에 어디에서든 액세스 할 수 있게 됩니다.
- 싱글톤 패턴에서의 중요한 개념은 private 접근 제어자를 활용한 생성자입니다. 생성자를 private으로 작성하면 `new` 키워드로 인스턴스화 할 수 없습니다.
```java
class Singleton {
  static final Singleton instance = new Singleton();
  //new 사용 불가
  private Singleton(){}
  Singleton getInstance() {
    return instance;
  }
}
```
### 팩토리
- 

## 2. 구조패턴
### 프록시
## 3. 행위패턴
