package org.example.aa;

public class SamsungCar extends Car {

    public SamsungCar(){}

    public SamsungCar(String name, String desc, String company){
        super.name=name;
        this.desc=desc;    //super를 this라고 적어도됨
        super.company=company;  //아예안적는건 불가
    }   //다른 생성자 선언해서 기본 생성자 생략 불가
    public void show(){
        System.out.println(
                name + " " +
                        desc + " " +
                        company
        );
    }

    @Override
    public String toString() {
        return "SamsungCar{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}