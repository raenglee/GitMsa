package org.example;

import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] productName;
        int[] productPrices;
        int productCount;

        while (true) {
            System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int option = scanner.nextInt();

                if (option == 1) {
                    System.out.print("상품 이름을 입력하세요: ");
                    String productName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("상품 가격을 입력하세요: ");
                    int productPrice = scanner.nextInt();
            } else if (option == 2) {
                    System.out.println(productName+": "+productPrices+"원");
                } else {
                    System.out.println("프로그램을 종료합니다.");
                }
        }
    }
}