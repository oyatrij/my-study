### Spring framework 란?
자바 및 코틀린 개발을 편리하게 해주는 오픈소스 프레임워크로 IOC, DI, AOP 등의 특징을 가지고 있습니다.
<br><br>
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

### Dispatcher servlet 이란?
HTTP로 들어오는 모든 요청을 받아 적합한 컨트롤러에 위임해주는 프론트 컨트롤러입니다.<br>
@RequsetMapping 어노테이션에 설정된 controller에 위임합니다.


