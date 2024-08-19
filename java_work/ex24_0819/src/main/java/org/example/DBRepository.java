package org.example;

import javax.swing.*;
import java.sql.*;

public class DBRepository {

    /*
        1. Class.forname jar 파일 추가 확인
        2. Connection DB연결
        3. PrepareStatement sql 구문 작성
        4. sql 구문 실행
        executeUpdate(); -> insert, update, delete, create, alter
        executeQuery(); -> select문 실행 할 때
    */

    public void insert() {
        Connection conn = null; // DB연결 객체
        PreparedStatement pstmt = null; // sql문 담는 객체

        try {
            // DB연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.57:3307/tth",
                    "root",
                    "1234");

            //sql 생성
            pstmt = conn.prepareStatement("INSERT INTO aa (name,age) VALUES (?,?)");
            String name = JOptionPane.showInputDialog("이름");
            pstmt.setString(1, name);
            int age = Integer.parseInt(JOptionPane.showInputDialog("나이"));
            pstmt.setInt(2, age);

            //sql 구문 실행
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {  // DB연결 끊기
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
            }
        }

    }

    public void delete() {
        Connection conn = null; // DB연결 객체
        PreparedStatement pstmt = null; // sql문 담는 객체

        try {
            // DB연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.57:3307/tth",
                    "root",
                    "1234");

            //sql 생성

            pstmt = conn.prepareStatement("delete from aa where idx =?");
            int idx = Integer.parseInt(JOptionPane.showInputDialog("idx"));
            pstmt.setInt(1, idx);

            //sql 구문 실행
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {  // DB연결 끊기
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
            }
        }
    }

    public void select() {
        Connection conn = null; // DB연결 객체
        PreparedStatement pstmt = null; // sql문 담는 객체

        //select 해서 반환되는 테이블 받기
        ResultSet rs = null;

        try {
            // DB연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.57:3307/tth",
                    "root",
                    "1234");

            //sql 생성
            pstmt = conn.prepareStatement("select * from aa");

            //sql 구문 실행
            rs = pstmt.executeQuery();
            while (rs.next()) {
//                System.out.println("idx = "+rs.getInt("idx"));
//                System.out.println("name = "+rs.getString("name"));
//                System.out.println("age = "+rs.getInt("age"));
                System.out.println("""
                        idx = %d
                        name = %s
                        age = %d
                        """.formatted(rs.getInt("int"),
                        rs.getString("name"),
                        rs.getInt("age")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {  // DB연결 끊기
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
            }
        }
    }

    public void update() {
        Connection conn = null; // DB연결 객체
        PreparedStatement pstmt = null; // sql문 담는 객체

        try {
            // DB연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.57:3307/tth",
                    "root",
                    "1234");

            //sql 생성
            pstmt = conn.prepareStatement("UPDATE aa SET NAME = ?, age = ? WHERE idx = ?");
            String name = JOptionPane.showInputDialog("이름");
            pstmt.setString(1, name);
            int age = Integer.parseInt(JOptionPane.showInputDialog("나이"));
            pstmt.setInt(2, age);
            int idx = Integer.parseInt(JOptionPane.showInputDialog("idx"));
            pstmt.setInt(3, idx);

            //sql 구문 실행
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {  // DB연결 끊기
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
            }
        }
    }
}