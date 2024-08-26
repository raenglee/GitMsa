package org.example;

public class CompFriend extends Friend{
    private String department;

    public CompFriend(String na, String de, String ph){
        super(na, ph);
        department = de;
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("부서: "+department);
    }
}