package org.example;

import java.util.Optional;

class ContInfo {
    String phone;
    String address;

    public ContInfo(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

public class Ex05 {
    public static void main(String[] args) {
        Optional<ContInfo> contInfo = Optional.of(
                new ContInfo(null, "KOREA DAEGU")
        );  // Optional에 ContInfo를 담아봄

        String phone = contInfo
                .map(contInfo1 -> contInfo1.getPhone())  // ContInfo안에있는 map을 Optional로
                .orElse("There is no Phone Number");  // 없으면 이렇게 출력하라

        System.out.println("phone = "+phone); // null이므로 orElse가 출력됨

        String address = contInfo
                .map(contInfo1 -> contInfo1.getAddress())
                .orElse("no address");

        System.out.println("address = "+address);  // KOREA DAEGU가 있으므로 orElse출력 안됨

//        String phone = null;
//        String address = null;
//
//        if (contInfo.getPhone() != null)
//            phone = contInfo.getPhone();
//        else phone = "EMPTY";
//
//        if (contInfo.getAddress() != null)
//            address = contInfo.getAddress();
//        else address = "EMPTY";
//
//        System.out.println("phone = " + phone);
//        System.out.println("address = " + address);
    }
}
