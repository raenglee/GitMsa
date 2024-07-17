/*
2. 자바 클래스를 작성하는 연습을 해보자. 다음 main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV 클래스를 작성하라.

    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
        myTV.show();
    }

    출력
    LG에서 만든 2017년형 32인치 TV
 */

import aa.TV;

public class Ex01 {
    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치  // TV에 알트+엔터로 클래스 임포트
        myTV.show();

    }
}