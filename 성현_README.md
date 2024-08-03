이것은 pjt1의 김성현의 기록이다..

## 소개
프로젝트의 목표 : 운동하길 원하는 근육 부위를 검색하면 적절한 운동 소개영상 업로드 그에 대한 리뷰들을 관리하는 프로그램
주요 기능 : 검색, 영상 리스트 출력, 리뷰 입출력

## 주요 코드
    - VideoManager.java
        add() , searchVideos() , listViedos() , getter setter 메서드 with Videos()
    
    - Video.java
        getter setter 메서드 with Info(), No() , Title() , Part() , Url()
    
    - User.java
        writeReview()

    - ReviewManager.java
        addReview() , listReviews()

    - Review.java
        display() , edit(), getter setter 메서드 with User() , Content() , Rating()
    
    - IVideoManager.java (인터페이스)
        addVideo() , List with searchVideos() , listVideos(), getVideos()

    - IReviewManager.java (인터페이스)
        addRevew() , List with listReviews

    - Launcher.java
        showVideoList() , showVideoDetail , writeReview with switch문 & while문 & 향상된 for문



## 발생한 갈등, 에로사항
 1. 메뉴 연출 방향

    * 영상 목록 페이지에서 영상 선택 메뉴와 돌아가기 메뉴의 세팅 여부
         - 해결 : 한 줄에 두 선택지를 모두 제시하고 그 아래 입력창을 만드는 것으로 해결
                    n영상 번호를 입력하세요 (돌아가려면 0을 누르세요)
                    선택: 
    
    * 리뷰 작성 후 첫 돌아가기 입력으로 돌아가는 위치에 대한 의견 ( 영화 목록으로 vs 리뷰 목록으로 )
        - 해결 : 일반적인 리뷰 페이지의 특징을 고려하여 리뷰 목록으로 돌아가게 설정
                    1. 돌아가기 (-> 리뷰 목록 페이지로)

 2. 구상과 다른 출력 발생

    * 메인 메뉴에서 다른 메뉴 페이지로 이동할 때에 지속적으로 메인 메뉴 출력 발생
        - 해결 : chatgpt를 통해 특정 상황에서만 메인 메뉴를 출력하도록 수정
                    1. 첫 출력 / 2. 영화목록 페이지에서 돌아가기 선택 시

    * json파일을 라이브 강의 때와 다르게 그대로 사용할 수 없는 상황 발생
        - 해결 : JsonUtil이라는 클래스를 가진 자바 파일을 추가하여 Launcher 파일에서 사용

## 프로젝트 타임라인
    1. gpt를 통해서 기본 기능에 대한 프로젝트 구조 설계
    2. gpt가 제공받은 아이디어를 통해 클래스 다이어그램 초안을 출력
    3. 예시에 입각하여 기본 기능을 갖춘 프로그램 코드 제작
    4. 메뉴 순서와 구성 등 세부적인 사항 조정
    5. 최종 결과물을 토대로 클래스 다이어그램 최종본 제작


## 아쉬운 점
 1. pdf에 제시된 기본 기능 구현에 집중하여 리뷰 삭제 및 심화 기능 등의 추가적인 기능 구현을 하지는 못함 
 2. 초기 기획은 영상 번호가 아닌 부위를 입력하고 그에 맞는 영상 목록 재출력이었으나 성공적인 출력을 위해 간소화하는 과정에서 추가하지 못함
 3. 클래스 다이어그램을 출력하는 프로그램의 차이로 인해 익숙한 형태의 클래스 다이어그램을 만들지 못함