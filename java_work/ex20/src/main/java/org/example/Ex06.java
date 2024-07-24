package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex06 {
    public static void main(String[] args) {

        try{
            // DB연결 유지 클래스
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aaa", "root", "1234");
            System.out.println("되나");

            PreparedStatement pstmt
                    = conn.prepareStatement("INSERT INTO student values('김길동', '100', '100')");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
