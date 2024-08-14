package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DBMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DBRepository dbRepository = new DBRepository();
        while (true){
            System.out.println("""
                    뭐할래?
                    1. 입력
                    2. 조회
                    3. 수정
                    4. 삭제
                    5. 종료""");
            int cho = scanner.nextInt();
            //insert 문 실행
            if(cho==1){
                dbRepository.insert();
            }
            //select 문 실행
            else if (cho==2) {
                dbRepository.select();
            }else {
                System.out.println("종료됩니다.");
                break;
            }
        }
    }
}