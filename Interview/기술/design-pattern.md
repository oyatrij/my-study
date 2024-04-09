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
### 팩토리 메소드
- 객체 생성을 공장(Factory)클래스로 캡슐화하여 생성하게 하는 생성 디자인 패턴이다.
- 클라이언트에서 직접 `new`연산자를 통해 인스턴스화 하는게 아닌 캡슐화 한 클래스의 메서드에서 인스턴스화 하여 생성을 각각 책임지는 것이다.
- 인스턴스화에 필요한 전,후처리를 가능하게 하여 객체를 유연하게 생성할 수 있습니다.
#### 팩토리 메서드 패턴 구조
- Creator: 최상위 공장 클래스로서, 팩토리 메서드를 추상화하여 서브클래스에서 구현하도록 합니다.
  - someOperation(객체 생성 처리 메서드): 객체 생성에 관한 전,후 처리를 템플릿화 한 메소드
  - createProduct(팩토리 메서드): 서브 공장 클래스에서 재정의할 객체 생성 추상 메서드
- ConcreteCreator: 각 서브 공장 클래스는 해당하는 제품 객체를 반환하도록 생성 추상메서드를 재정의 합니다.
- Product: 제품 구현체를 추상화합니다.
- ConcreteProduct: 제품 구현체입니다.
<br>
팩토리 메소드 패턴은 객체를 만들어내는 공장을 만드는 패턴입니다. 클래스의 인스턴스는 미리 정의한 공장의 서브클래스에서 결정합니다. 팩토리 메소드 패턴으로 구성하게 되면 객체간의 결합도가 낮아지고 유지보수에 용이해집니다.

#### 구현
- 제품(Product)클래스
```java
//제품 추상화
public interface IProduct {
  void setting();
}

//제품 구현체
public class ConcreteProductA implement IProduct {
  @Override
  public void setting() {
  }
}

public class ConcreteProductB implement IProduct {
  @Override
  public void setting() {
  }
}
```
- 공장(Factory)클래스
```java
abstract class AbstractFactory {
  // 객체 생성 전,후처리 메소드 (final을 적용하여 오버라이딩 방지, 템플릿화)
  final IProduct createOperation() {
    IProduct product = createProduct();
    product.setting 
  }

  //팩토리 메소드: 구체적인 객체 생성 종류는 각 서브클래스에 위임한다.
  //Protected를 정용하여 때문에 외부에 노출되지 않게 한다.
  abstract protected IProduct createProduct();
}

```

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
- 전략생성
&nbsp;현재 개발하려고하는 교통수단의 이동 방법은 선로와 도로, 두가지 방식이 있습니다. 움직이는 방식에 대한 **Strategy**클래스를 생성합니다.
```java
//MovableStrategy Interface
public interface MoveableStrategy {
  public void move();
}

//선로이용기능
public class RailLoadStrategy implements MoveableStrategy {
  @Override
  public void move() {
    System.out.println("선로이용");
  }
}

//도로이용기능
public class LoadStrategy implements MoveableStrategy {
  @Override
  public void move() {
    System.out.println("도로이용");
  }
}

//다른 기능 추가
...

```

이제 운송 수단에 대한 클래스를 정의 합니다. 어떻게 움직일 것인지에 대한 전략을 설정하여, 그 전략의 움직임 방식을 사용하여 움직이도록 합니다.
```java
public class Moving {
  private MovableStrategy movableStrategy;
  public void move(){
    movableStrategy.move();
  }
  public void setMovableStrategy(MovableStrategy movablestrategy) {
    this.movableStrategy = movableStrategy;
  }
}

public class Bus extends Moving {
  
}

public class Train extends Moving {

}
```

이제 Train과 Bus객체를 사용하는 Client를 구현합니다.<br>
각 운송 수단을 생성하고 운송 수단들이 어떤 방식으로 움직이는지에 대한 방식을 **setMovableStrategy()** 메서드를 통해 설정합니다.
```java
public class Client {
  public static void main(String args[]) {
    Moving train = new Train();
    Moving bus = new Bus();

    //기차는 선로를 이용하고, 버스는 도로를 이용한다.
    train.setMovableStrategy(new RailLoadStrategy());
    bus.setMovableStrategy(new LoadStrategy());

    train.move();
    bus.move();

    //버스의 이동방식이 선로로 바뀌었다.
    bus.setMovableStrategy(new RailLoadStrategy())
  }
}
```
버스의 이동방식이 선로로 바뀌었지만 인터페이스와 클래스에서는 수정을 하지않아 OPC원칙을 지켜냈습니다.<br>
또, 행위가 추가되어도 추가된 행위에 대한 클래스를 개발하여 확장에 대해서는 열려있게 되어 OPC원칙을 지켰습니다.<br>
다시 한 번 정리하자면 전략패턴은 객체의 행위를 캡슐화하고 객체의 행위를 변경할 때 행위를 수정하지않고 객체가 행위를 변경하여 개발하는 디자인 패턴입니다. 


