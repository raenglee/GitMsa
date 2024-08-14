package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBRepository {

    //1. insert
    //2. select
    //3. update
    //4. delete

    //insert
    public void insert() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("이름 입력");
            String name = scanner.next();
            System.out.println("나이 입력");
            int age = scanner.nextInt();

            //1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.  db connection db연결확인
            Connection conn =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/pmh",
                                    "root",
                                    "12345678");
            System.out.println("연결성공");
            //3. sql 문 작성
            PreparedStatement pstmt
                    = conn.prepareStatement("INSERT INTO aa (name,age) VALUES (?,?)");
            pstmt.setString(1,name);  //1번 물음표는 이름
            pstmt.setInt(2,age);  //2번 물음표는 나이가 들어갈것이다
            //4. sql 문 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(){
        System.out.println("select 해야함");
    }
}