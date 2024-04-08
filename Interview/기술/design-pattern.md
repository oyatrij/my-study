## SOLID 란?
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
### 전략패턴 (Stragey Pattern)
- 전략패턴은 객체지향언어의 캡슐화를 사용한 패턴입니다. 유사한 기능을 캡슐화하여 인터페이스를 정의하고 객체의 행위를 동적으로 바꾸고 싶은 경우 직접 행위를 수정하지 않고 전략을 바꿔 행위를 유연하게 확장하는 방법입니다.

#### 전략패턴을 사용하지 않으면 일어나는 일
```java
public interface Movable {
  public void move();
}

public class Train implements Movable {
  public void move() {
    System.out.println("선로를 통해 이동");
  }
}

public class Bus implements Movable {
  public void move() {
    System.out.println("도로를 통해 이동");
  }
}

public class Client {
  public static void main(String[] args) {
    Movable train = new Train();
    Movable bus = new Bus();

    train.move();
    bus.move();
  }
}
```
위 코드에서 기차는 선로를 통해 이동하고 버스는 도로를 통해 이동합니다. 만약 버스가 선로를 통해 이동하는 것으로 기능을 변경해야한다면 Bus 클래스에서 override한 move()를 수정 해야합니다. 하지만 이는 **SOLID원칙 중 OCP**에 위배됩니다. OCP에 의거하여 수정을 하려면 직접 클래스를 수정하는게 아닌 새로운 클래스를 생성해야합니다.<br>
만약 bus뿐 아니라 택시, 오토바이 등 다른 교통수단도 '도로를 통해 이동'으로 개발해놨는데 모두 '선로를 통해 이동'으로 변경해야된다면 택시, 오토바이 클래스의 move()메서드를 모두 수정해야하니 유지보수성이 떨어집니다.<br>
**전략패턴**은 이러한 문제를 해결하기 위해 사용됩니다.<br>

#### 전략패턴의 활용

