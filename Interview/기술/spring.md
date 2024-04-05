### Spring framework 란?
자바 및 코틀린 개발을 편리하게 해주는 오픈소스 프레임워크로 IOC, DI, AOP 등의 특징을 가지고 있습니다.
<br><br>

### Spring MVC란?
SpringMVC는 Spring framework 의 model-view-controller 구조를 이용해 웹 애플리케이션을 개발하는 프레임워크입니다. 동작방식은 request가 들어오게되면 filter를 거처 dispatcher servlet(front controller)가 HandlerMapping에 던지게됩니다. HandlerMapping은 request에 적합한 controller를 찾아 연결하고 DispatcherServlet으로 돌아와 HandlerAdapter로 요청합니다. HanderAdapter는 controller의 메소드들 중 적합한 메소드를 매칭하고 ViewResolver를 통해 적합한 View를 찾아 반환합니다.
<br><br>

### 객체지향 프로그래밍이란?
현실 세계에 존자하는 객체를 소프트웨어에 표현하는 프로그래밍 기법입니다.<br>
객체지향의 특징은 캡슐화, 정보은닉, 상속, 다형성이 있습니다.
- 캡슐화 - 변수와 함수를 하나의 단위로 묶는 것 입니다. 클래스로 구현되며 인스턴스 생성을 통해 클래스 안에 포함된 멤버 변수와 메소드에 쉽게 접근할 수 있습니다.
- 정보은닉 - 프로그램의 세부 구현을 외부로 드러나지 않도록 모듈 내부에 감추는 것 입니다. 노출을 최소화하여 모듈 간의 결합도를 떨어뜨려 유연성과 유지보수성을 높입니다.
- 상속 - 부모 클래스의 특성과 기능을 자식 클래스가 그대로 물려받는 것을 말합니다. 상속을 통해 재사용성을 용이하게 한다.
- 다형성 - 같은 이름의 메서드나 연산자가 다른 클래스에서 다른 동작을 하도록하는 개념입니다.<br>
크게 메서드 오버라이딩과 메서드 오버로딩이 있으며, 메서드 오버라이딩은 부모 클래스의 메서드를 자식 클래스에서 재정의하여 사용하는 것을 말합니다. 메서드 오버로딩은 같은 이름의 메서드의 매개변수를 다르게 하여 다른 동작을 하도록 하는 것 입니다.
<br><br>

### SOLID 란?
객체지향에 꼭 지켜야 할 5개의 원칙입니다.
- SRP(Single Responsibility Principle) : 단일 책임 원칙 - 객체는 오직 하나의 책임을 가져야 한다는 뜻으로 클래스의 목적을 명확히 함으로써 수정사항이 불필요하게 넓게 퍼지는 것을 예방하고 기능을 명확히 분리할 수 있게 합니다.
- OCP(Open-Closed Principle) : 개방-패쇄 원칙 - 객체는 확장에 대해서는 개방적이고 수정에 대해서는 폐쇄적이어야 한다는 원칙입니다.
- LSP(Liskov Substitution Principle : 리스코프 치환 원칙 - 자식 클래스는 언제나 자신의 부모 클래스를 대체할 수 있다는 원칙입니다. 부모클래스가 들어갈 자리에 자식 클래스를 넣어도 잘 작동해야 상속을 본질을 잘 지킨 것 입니다. 이를 지키지 않으면 부모 클래스 본래의 의미가 변해 다형성을 지킬 수 없게 됩니다.
- ISP(Interface Segregation Principle) : 인터페이스 분리 원칙 - 클라이언트에서 사용하지 않는 메서드는 사용하면 안된다는 원칙입니다. 사용하지 않는 메서드가 있으면 인터페이스를 더 작게 나누어 만들어야 합니다.
- DIP(Dependency Inversion Principle(DIP) : 의존성 역전 원칙 - 어떤 클래스를 참조해서 사용해야 한다면 직접 그 클래스를 참조하는 것이 아닌 그 클래스의 상위 요소인 추상클래스나 인터페이스로 참조해야 한다는 원칙입니다.

### IOC 란?
제어의 역전이라는 뜻으로 객체의 생성과 생명주기 및 의존성 주입을 스프링에서 관리하는 것 입니다.
<br><br>
### DI 란?
의존성 주입이라는 뜻으로 객체간의 관계를 외부에서 설정해주는 디자인 패턴입니다. 인터페이스를 사이에 둬서 클래스 레벨에서는 의존관계가 고정되지않고 런타임시 동적으로 주입됩니다.
의존성 주입 방법에는 생성자 주입, 필드 주입, setter 주입 등이 있습니다. Spring 4부터는 생성자 주입을 권장하고 있습니다. 
<br><br>
### 의존성 주입 방법
1. 생성자 주입
- 생성자를 통해 의존관계를 주입하는 방법이다.
- 생성자의 호출 시점에 1회 호출되는 것이 보장된다.
```java
@Service
public class UserService {
  private UserRepository userRepository;
  private MemberService memberService;

  @Autowired
  public UserService(UserRepository userRepository, MemberService memberService) {
    this.userRepository = userRepository;
    this.memberService = memberService;
  }
}
```
2. setter 주입
- 필드값을 변경하는 setter를 통해 의존관계를 주입한다.
- 주입받는 객체가 변경될 가능성이 있는 경우에 사용
```java
@Service
public class UserService {
  private UserRepository userRepository;
  private MemberService memberService;

  @Autowired
  public void setMemberService(UserRepository userRepository) {
    this.userRepsository = userRepository; 
  }

  @Autowired
  public void setMemberService(MemberService memberService) {
    this.memberService = memberService;
  }
}
```
3. 필드 주입
- 필드에 바로 의존관계를 주입하는 방법.
- 필드주입은 코드가 간결해지지만 외부에서 접근이 불가능하다는 단점.
- 반드시 DI 프레임워크가 존재해야 하므로 사용 지양
```java
@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private MemberService memberService;
}
```
<br><br>
### Filter란?
Request가 DespatcherSevlet에 도달하기 전, 후에 동작하며 주로 인증, 권한 체크 등을 하는데 사용됩니다.<br>
- init(): 필터가 생성될 때 수행
- doFilter(): Request, Response가 필터를 거칠 때 수행
- destroy(): 필터가 소멸될 때 수행
<br><br>

### Interceptor란?
Filter와 비슷하지만 Interceptor는 Dispatcher Servlet 이 실행된 후에 호출되고 스프링컨테이너에서 관리되기 때문에 모든 Bean에 접근할 수 있다는 특징이 있습니다.

### Dispatcher servlet 이란?
HTTP로 들어오는 모든 요청을 받아 적합한 컨트롤러에 위임해주는 프론트 컨트롤러입니다.<br>
@RequsetMapping 어노테이션에 설정된 controller에 위임합니다.
<br><br>

### Bean scope란?
빈이 존재할 수 있는 범위를 이야기합니다.<br>
- 싱글톤: 디폴트 스코프로 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프입니다.
- 프로토타입: 스프링 컨테이너는 프로토타입 **빈의 생성**과 **의존관계 주입**까지만 관여하고, 더는 관리하지않는 매우 짧은 범위의 스코프입니다.<br>
어노테이션으로 스코프를 설정할 수 있습니다.
```java
@Scope("singleton")
@Scope("prototype")
```
