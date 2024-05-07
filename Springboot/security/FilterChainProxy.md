## FilterChainProxy
- Springsecurity 의존성을 추가하면 기본적으로 DefaultSecurityFilterChain 하나가 등록된다.
- DefaultSecurityFilterChain이 등록되면 프로젝트 실행 시 자동으로 로그인 화면이 생성된다.

`FilterChainProxy.class`의 아래 메서드에 Breakpoint를 걸고 프로젝트를 실행시키고 웹브라우저에서 접속해보면<br/>
기본으로 추가된 DefaultSecurityFilterChain과 여러 필터들을 확인할 수 있다.
```java
//FilterChainProxy.class
private List<Filter> getFilters(HttpServletRequest request) {
  ...
}
```
![image](https://github.com/oyatrij/my-study/assets/118187065/c24f8076-e8be-4e06-9f77-7e05e09e07fe)

-Custom SecurityFilterChain을 등록하게되면 `DefaultSecurityFilterChain`은 해제된다.

## DelegatingFilterProxy
- WAS 컨테이너의 필터에서 시큐리티의존성이 추가되어있는 필터를 FiterChainProxy의 Bean에 전달하는 역할을 한다.



## Custom SecurityFilterChain 등록
- SecurityFilterChain을 리턴하는 @Bean을 등록하면 된다.

```java
//SecurityConfig.java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain1(HttpSecurity http) thorws Exception {
    return http.build();
  }
}
```

주의할 점은 두 개의 SecurityFilterChain을 등록했을 때 이다.<br>
두 개의 SecurityFilterChain을 등록했을 때는 securityMachers로 경로를 지정해줘야한다.

```java
@Bean
public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {

    http
            .securityMatchers((auth) -> auth.requestMatchers("/user"));

    http
            .authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/user").permitAll());

    return http.build();
}

@Bean
public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {

    http
            .securityMatchers((auth) -> auth.requestMatchers("/admin"));

    http
            .authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/admin").authenticated());

    return http.build();
}
```
