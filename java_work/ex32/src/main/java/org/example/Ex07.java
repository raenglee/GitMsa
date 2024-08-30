package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {

        List<AA> list = new ArrayList<>();
        try (Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/kce", "root", "1234")) {
            PreparedStatement pstmt = conn.prepareStatement("select * from aa order by idx desc");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AA member = AA.builder()
                        .name(rs.getString("name"))
                        .idx(rs.getInt("idx"))
                        .age(rs.getInt("age"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .regdate(rs.getObject("regdate", LocalDateTime.class))
                        .mydate(rs.getObject("mydate", LocalDateTime.class))
                        .build();
                list.add(member);
            }

            list.stream()
                    .forEach(System.out::println);

            //라이브러리 추가 되어 있는지 확인
//            Class.forName("com.mysql.cj.jdbc.Driver");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
