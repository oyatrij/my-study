### HTTP란?
하이퍼텍스트 전송 프로토콜의 약자로 웹에서 데이터를 주고받는데 사용되는 기본적인 프로토콜입니다.<br>
HTTP는 Request Line or Status Line, Header, Blank line Body 로 나누어져있습니다.<br>
Header는 다음 네 가지로 나뉩니다.
- General Header
  - Date(HTTP 메시지 생성시간), Connection(서버와 클라이언트의 연결 옵션), Via(메시지가 어느 중개자를 거쳐서 왔는)
- Request Header
- Response Header
- Entity Header
<br><br>

### REST란?
HTTP 요청을 보낼 때 URI로는 자원을, HTTP Method로는 행위를 표현한 client와 server의 통신 스타일입니다.
<br><br>

### HTTP method 중에서 PUT과 PATCH의 차이는?
PUT과 PATCH 모두 Update를 위한 Http method입니다.<br>
PUT으로 업데이트 시 데이터 전체가 덮어 쓰여지게되어 갱신되고, PATCH는 일부분만 수정되어집니다.<br>
<br><br>

### 멱등성이란?
연산을 여러 번 해도 결과가 달라지지 않는 성질이며 GET 요청은 멱등성이 지켜지지만 POST는 수행할 때 결과가 달라지므로 멱등성이 지켜지지않습니다.
<br><br>
