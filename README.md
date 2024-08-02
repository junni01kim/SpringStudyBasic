## [2024 프로보노 ICT 멘토링] ICT 멘토링 레벨업 패스 스프링 기초/심화 학습 예제

웹서버 공부를 위한 강의 예제 따라가기이며,  
주차별 커밋은 강좌 따라적기 + 주석으로 정리하기 1회, 미션 풀이 1회로 진행할 계획이다.

### [미션 1] 바우처 관리 애플리케이션을 Command-line Application으로 제작한다.
#### 과제는 다음과 같다.
스프링부트 애플리케이션으로 만든다. (Web기능이 없이만듭니다. 즉, 서버가 띄지 않고 커맨드라인 애플리케이션으로 동작해야한다.)

프로그램이 시작하면 다음과 같이 지원가능한 명령어를 알려준다.

```
=== Voucher Program ===
Type **exit** to exit the program.
Type **create** to create a new voucher.
Type **list** to list all vouchers.
create / list 커맨드를 지원한다.
```

create 커맨드를 통해 바우처를 생성할수 있다. (FixedAmountVoucher, PercentDiscountVoucher)

list 커맨드를 통해 만들어진 바우처를 조회할 수 있다.