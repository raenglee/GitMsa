package org.example;

import java.util.Scanner;

public class Main {
    Main() {
        System.out.println("되나");

        Scanner scanner = new Scanner(System.in);
        DBRepository dbRepository = new DBRepository();
        while (true) {

            System.out.println("""
                    뭐할래?
                    1. 입력
                    2. 조회
                    3. 수정
                    4. 삭제
                    5. 종료""");
            int cho = scanner.nextInt();
            System.out.println(cho);
            if (cho == 1) {
                dbRepository.insert();
            } else if (cho == 2) {
                dbRepository.select();
            }
            else if (cho == 3) {
                dbRepository.update();
            }
            else if (cho == 4) {
                dbRepository.delete();
            } else {
                System.out.println("종료됩니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {

        new Main();

    }
}