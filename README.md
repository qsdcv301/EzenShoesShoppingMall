# 📚 웹 애플리케이션 개요

## 1. 🚀 프로젝트 이름

**Ezen Shoes ShoppingMall**  
🔗 [웹사이트 바로가기](http://ezenbookstore.kro.kr:8081/)

---

## 2. 📖 프로젝트 개요

- **📌 목적**: 온라인 이커머스 프로젝트에 대한 이해 및 학습을 위한 팀 프로젝트
- **🎯 주요 목표**:
  - ✅ 유저 / 관리자별 기능 제공
  - ✅ 회원가입, 로그인, 내정보 수정 기능
  - ✅ 장바구니, 구매기록 기능
  - ✅ 배송비 시스템 (조건부 무료)
  - ✅ 결제 및 조회 기능 - (PG사 연동 X)
  - ✅ 상품 및 게시판 등록 및 관리 - (리뷰, 공지사항 등)

---

## 3. 🔧 기술 스택

### 🛠️ 개발 도구  

![VS Code](https://img.shields.io/badge/IDE-VS%20Code-blue?logo=visualstudiocode&logoColor=white)  ![IntelliJ](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-orange?logo=intellijidea&logoColor=white)

### 🎨 프론트엔드  

![HTML](https://img.shields.io/badge/HTML-E34F26?logo=html5&logoColor=white)  ![CSS](https://img.shields.io/badge/CSS-1572B6?logo=css3&logoColor=white)  ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=black)  ![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap&logoColor=white)

### 🔙 백엔드  

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)  ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=white)  ![JPA](https://img.shields.io/badge/JPA-6DB33F?logo=hibernate&logoColor=white)  ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=black)

### 🗄️ 데이터베이스  

![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)  

### 🤝 협업 도구  

![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)

### ⚙️ 기타 도구  

![Jenkins](https://img.shields.io/badge/Jenkins-D24939?logo=jenkins&logoColor=white)  ![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white)  ![Oracle](오라클 서버)

---

## 4. 👥 참여자 및 역할

| 이름       | 역할                        | GitHub                                  | Email                         |
|------------|-----------------------------|-----------------------------------------|-------------------------------|
| 김태현    | [팀장 / BackEnd]            | [GitHub](https://github.com/qsdcv301)  | <qsdcv301@naver.com>            |
| 채윤성    | [역할 입력 필요]            | [GitHub](https://github.com/ChaiTope)  | <gksmsk5094@gmail.com>          |
| 이정인    | [역할 입력 필요]            | [GitHub](https://github.com/GreatOvOb)| <dlwjddls888@gmail.com>         |
| 정재환    | [역할 입력 필요]            | [GitHub](https://github.com/JaeHwan2569)| <jjjhhh2569@gmail.com>         |
| 황예주    | [역할 입력 필요]            | [GitHub](https://github.com/HwangYeJoo)| <jooland05@gmail.com>           |

---

## 5. 📜 주요 기능 설명

### 💻 사용자 페이지

- 🔑 **회원가입 및 로그인**
  - 일반 회원가입 및 소셜 로그인 지원 (Google, Naver, Kakao)
- 🛒 **장바구니 및 구매 기록 조회**
- 💰 **적립금 시스템**
  - 상품 구매 및 이벤트 참여 시 적립금 지급
  - 일정 적립금 이상 시 구매에 사용 가능

### 🛠️ 관리자 페이지

- 📦 **상품 등록 및 관리**
- 📝 **게시판 관리**
  - 공지사항 ,이벤트, 리뷰, Q&A를 통해 게시물의 추가 삭제를 관리함
- 🚚 **배송비 시스템**
- 💳 **결제 및 조회**

---

## 6. 📐 아키텍처 다이어그램

| 다이어그램 유형       | 이미지                                                         |
|-----------------------|----------------------------------------------------------------|
| 시스템 아키텍쳐 다이어그램       | ![아키텍처 다이어그램](./read.me.image/00architecturediagram.png) |
| 프로세스 다이어그램           | ![유저 흐름도](./read.me.image/01architecturediagram.png)      |
| 관리 프로세스 다이어그램         | ![관리자 흐름도](./read.me.image/02architecturediagram.png)    |

---

## 7. 🛢️ DB(RDBMS)

### 관계형 데이터베이스 설계

- **데이터 무결성 및 효율성**
  
  - **정규화**: 데이터 중복을 최소화하기 위해 테이블을 정규화하여 설계
  - **인덱스 설계**: 외래 키 및 자주 조회되는 필드에 인덱스를 설정하여 쿼리 성능 최적화

- **확장성 및 유지보수성**
  
  - **모듈화된 테이블 구조**: 각 기능별로 테이블을 분리하여 향후 기능 추가 및 변경 시 유연하게 대응
  - **외래 키 및 관계 설정**: 테이블 간의 관계를 명확히 정의하여 데이터 연동 강화

- **보안 및 접근 제어**
  
  - **민감한 사용자 데이터 암호화 저장**
    - `user` 테이블의 `password` 필드는 해시 알고리즘(Bcrypt 등)을 통해 암호화 저장
    - 이메일, 주소 등 민감한 정보는 추가적인 암호화 고려

- **역할 기반 접근 제어 (RBAC)**
  
  - 단순한 필드로 권한을 구분하여 부여함
  - 추가적으로 프로젝트가 커진다면 테이블로 나눠 사용자 액세스 권한을 나눌 필요가 있음

---

## 8. 📊 ERD

| ERD       | 이미지                                                         |
|-----------------------|----------------------------------------------------------------|
| ERD       | ![ERD](./read.me.image/00erd.png) |

---

## 9. 🖼️ 화면 예시

| 화면 설명               | 이미지                                                         | 설명                                                             |
|-------------------------|----------------------------------------------------------------|------------------------------------------------------------------|
| 메인 페이지            | ![메인 페이지](./read.me.image/00main.png)                     | 메인 페이지는 사용자가 사이트에 처음 접속했을 때 표시되는 기본 화면입니다. |
| 상품 메인 페이지       | ![상품 메인 페이지](./read.me.image/01bookproduct.png)         | 상품 목록과 각 상품의 상세 정보를 확인할 수 있는 페이지입니다.     |
| 상품 디테일 페이지       | ![상품 디테일 페이지](./read.me.image/01bookdetail.png)         | 상품 클릭시 상품의 상세정보를 볼 수 있는 상품 디테일 페이지입니다.     |
| 회원가입1 페이지        | ![회원가입1 페이지](./read.me.image/02signup1.PNG)                | 회원가입을 할 수 있는 페이지입니다. |
| 회원가입2 페이지        | ![회원가입2 페이지](./read.me.image/02signup2.PNG)                | 회원가입을 할 수 있는 페이지입니다. |
| 로그인 페이지        | ![로그인 페이지](./read.me.image/03login.PNG)                | 회원가입 후 로그인 또는 간편 소셜로그인을 할 수 있는 페이지입니다. |
| 마이페이지 - 나의정보        | ![마이페이지 - 나의정보](./read.me.image/04mypage_profile.png)                | 가입한 정보를 확인하고 수정할 수 있는 페이지입니다. |
| 장바구니 페이지        | ![장바구니 페이지](./read.me.image/05Cart.png)                | 사용자가 선택한 상품들을 확인하고 결제를 진행할 수 있는 페이지입니다. |
| 주문 확인 모달        | ![주문 확인 모달](./read.me.image/05order.PNG)                | 주문하기 전 정보를 확인하고 구매할 수 있는 모달창입니다. |
| PG연동 모달        | ![PG연동 모달](./read.me.image/05PG_Pay.PNG)                | 결제시 PG사 연동하여 결제할 수 있는 모달창입니다. |
| 마이페이지 - 주문내역        | ![마이페이지 - 나의정보](./read.me.image/06mypage_orderlist.PNG)                | 주문한 정보를 확인할 수 있는 페이지입니다. |
| 주문내역 상세 모달        | ![주문내역 상세 모달](./read.me.image/07orderlist_check.PNG)                | 주문내역을 상세하게 확인할 수 있는 페이지입니다. |
| 관리자페이지 - 대시보드        | ![관리자페이지 - 대시보드](./read.me.image/8Admin_Dashboard.png)                | 관리자페이지에 처음 접속하면 한 눈에 확인하고 관리할 수 있는 페이지입니다. |
| 관리자페이지 - 상품관리페이지        | ![관리자페이지 - 상품관리페이지](./read.me.image/9Admin_Product.png)                | 상품을 등록하고 조회, 관리할 수 있는 페이지입니다. |
| 관리자페이지 - 이벤트 관리 페이지        | ![관리자페이지 - 이벤트 관리 페이지](./read.me.image/10Admin_Event.png)                | 이벤트를 등록하거나 관리할 수 있는 페이지입니다. |
| 이벤트 추가 모달        | ![이벤트 추가 모달](./read.me.image/10Event_add.PNG)                | 이벤트를 추가할 수 있는 모달창입니다. |
| 최근 본 도서 확인        | ![최근 본 도서 확인](./read.me.image/booklist.PNG)                | 최근 본 도서 목록을 볼 수 있는 창입니다. |
| 페이지 네비게이션 버튼        | ![관리자페이지 - 대시보드](./read.me.image/Detail_Buttun.PNG)                | 홈으로 돌아가기 / 상단으로 이동 / 관리자모드 / 최근 본 상품목록 버튼입니다. |

---

## 10. 📅 참고 사이트

- 🌐 [교보 문고](https://www.kyobobook.co.kr/) : 최근 본 컨텐츠 기능의 UI 디자인과 기능을 참고했습니다. (참고일 : 2024년 11월 18일)
- 🌐 [예스24](https://www.yes24.com/main/default.aspx) : 상품목록페이지의 UI 디자인(썸네일 타입)을 참고했습니다. (참고일 : 2024년 11월 07일)
- 🌐 [바로보네](https://www.barovone.com/kr/index/index.lime) : 상품목록페이지의 UI 디자인(리스트 타입, 상품 정렬)을 참고했습니다. (참고일 : 2024년 11월 07일)
- 🌐 [반디앤루디스](https://www.bandinlunis.com/front/main.do) : UI 디자인과 검색 내 재검색 기능을 참고했습니다. (참고일 : 2024년 11월 10일)
- 🌐 [알라딘](https://www.aladin.co.kr/home/welcome.aspx) : header의 UI 디자인을 참고했습니다. (참고일 : 2024년 11월 17일)

---

## 📎 부록

- 📑 **참조 문서**: [GoogleSheets](https://docs.google.com/spreadsheets/d/1WWVkoUGsloOn0snaAWEqKUIScwqnn0oSytphYaBP-OQ/edit?gid=290479822#gid=290479822)
