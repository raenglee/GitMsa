package org.example.friend;

public class UniFriend extends Friend{
      private String major;

    public UniFriend(String name, String phone, String major) {
        super(name, phone); // Friend로 보내줌
        this.major = major;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("전공 = " + major);

    }

    @Override
    public String toString() {
        return "UniFriend{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}