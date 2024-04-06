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
