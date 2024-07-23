package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
interface
변수 public static final 안적어도 됨
몸체가 없는 메서드를 정의 가능 public 안적어도 됨
ex) void  doA();

class를 만들어서 interface 상속 받아야 한다.
상속받으면 doA() 메서드를 재정이 해줘야한다

default() static() 라는 메서드를 추가할 수 있다
둘 다 메서드 안에 내용(바디, 몸체)이 존재해도 된다.

default() -> new 라는 예약어를 통해 사용
static() -> Printable.doA(); 인터페이스명과 함수명을 넣어서 바로 직접 사용 가능

람다 규칙은...
interface 하나의 추상 메서드가 존재해야 한다.
() -> {}

docker desktop
데이터베이스 종류 많음
MYSQL 서버 설치함

가상 OS
docker run 명령어 설치

java언어로 접속도 해볼 예정
heidsql 클라이언트 프로그램으로 서버 접속

서버 접속엔 try{} catch 구문이 필요함

18장
try{} catch{} 예외상황에 대한 학습
 */

public class Ex03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("a: ");
            int a = scan.nextInt();
            System.out.print("b: ");
            int b = scan.nextInt();

            System.out.println("나누기 시작");
            System.out.println(a / b);
            System.out.println("나누기 끝");

            int c[] = new int[3];
            System.out.println(c[4]);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (InputMismatchException ie) {
            System.out.println("문자를 넣으면 안돼요.");
        } catch (Exception p) {
            System.out.println("이것은 모든것의 예외 상황");
        }
        System.out.println("정상 종료 되었습니다.");
    }
}