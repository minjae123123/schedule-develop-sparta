# Schedule Develop API
유저를 생성하고 로그인한 뒤, 일정과 댓글을 생성, 조회, 수정, 삭제할 수 있는 REST API 서버입니다.
세션 기반 인증을 사용하며, 일정 목록 조회 시 댓글 수와 작성자 이름을 함께 제공합니다.

# 사용 기술
- java 17
- spring boot
- mysql
- jpa

# ERD
<img width="758" height="560" alt="image" src="https://github.com/user-attachments/assets/b1aaba23-d0f5-4d27-bd8b-a1ff95a4c0ad" />

# 프로젝트 구조
<img width="562" height="767" alt="image" src="https://github.com/user-attachments/assets/11708128-df0b-4970-ae3d-96eaf13a16ce" />

- controller : HTTP 요청/응답 처리
- dtos : 요청 및 응답 데이터 전달
- entity : 일정, 댓글, 공통 시간 각각의 필드 정의
- exception : 입력값 검증 처리
- repository : 데이터를 접근하는 인터페이스
- service : 일정/댓글 비즈니스 로직

# API 명세
[https://www.notion.so/API-341cd1f1b02f80058ddbff44dba06ba4?showMoveTo=true&saveParent=true](https://www.notion.so/API-34bcd1f1b02f809e868deeedc3a3bff3)

# application.properties
<img width="1182" height="621" alt="image" src="https://github.com/user-attachments/assets/9a6c04dc-c54f-4c9f-8f22-e2fa96f7925b" />


