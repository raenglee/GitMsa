package org.example;

class Friend{
    protected String name;
    protected String phone;

    public Friend(String na, String ph){
        name=na;
        phone=ph;
    }
    public void showInfo(){
        System.out.println("이름: "+name);
        System.out.println("전화: "+phone);
    }
}

public class ex00 {
    public static void main(String[] args) {
       Friend[] frns = new Friend[10];
       int cnt = 0;

       frns[cnt++] = new UnivFriend("LEE","Computer","010-555-333");frns[cnt++] = new UnivFriend("LEE","Computer","010-555-333");
       frns[cnt++] = new UnivFriend("KIM","Electronics","010-555-333");frns[cnt++] = new UnivFriend("LEE","Computer","010-333-888");
       frns[cnt++] = new CompFriend("YOON","R&D 1","053-555-333");frns[cnt++] = new UnivFriend("LEE","Computer","010-222-333");
       frns[cnt++] = new CompFriend("PARK","R&D 2","02-555-333");frns[cnt++] = new UnivFriend("LEE","Computer","010-777-111");

        for (int i = 0; i < cnt; i++) {
            frns[i[]

        }
    }
}
