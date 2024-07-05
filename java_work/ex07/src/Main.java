// shift + F10 현재 설정된 파일 실행
// ctrl + Shift + f10 열려진 파일 실행
// ctrl + alt + l 자동정렬
// ctrl + / 전체 주석처리
// 인텔리제이는 파일중에 몇개 에러면 실행이 안됨
// Alt + Shift + , or . - 글자크기
// Shift + del 한줄삭제
// 메뉴 한글로 변경 하지말기 (어차피 영어익숙해져야함)
// Shift + 엔터 바로 새줄 만들기
// Alt + 1 프로젝트 경로 확인
// Alt + insert 파일 생성
//ctrl + e 원하는 파일로 이동 가능
//esc - 소스로 다시 돌아옴
//새파일: new - module
//Sihft 2번 파일 찾기
//Ctrl+F4 지금 보는 창 닫기
//Ctrl+F2 실행멈추기
//Alt + enter 빠른 에러처리

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    /*
    1+(2+)+(1+2+3)...(1+2+3+4+...+10)
    의 결과를 출력하여라

    i = 0일때 j가 0에서 0+1미만 반복해라 = j < i+1
    i = 1일때 j가 0에서 1+1미만 반복해라
    i = 2일때 j가 0에서 2+1미만 반복해라
    i = 3일때 j가 0에서 3+1미만 반복해라 = (1+2+3)
    i = 4일때 j가 0에서 4+1미만 반복해라
    ...
    i = 10일때 j가 0에서 10+1미만 반복해라
    */

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 0; i < 11; i++) {

            for (int j = 1; j < i + 1; j++) {
                System.out.println("j=" + j);
              sum = sum+j;
            }

            System.out.println("sum="+sum);
        }
    }
}