package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ex06 {
    public static void main(String[] args) {

        MemberDBRepository memberDBRepository = new MemberDBRepository();
        List<Member> list = memberDBRepository.select();
        list.stream()
                .forEach(s-> System.out.println(s));
//        list.stream().forEach(System.out::println);
    }
}