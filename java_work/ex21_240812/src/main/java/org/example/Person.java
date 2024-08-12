package org.example;

// person 클래스를 배열로 가져올 경우 arrays sort로 정렬이 안됨
// comparable compareTo 사용

// 생성자 getter, setter, ToString
public class Person implements Comparable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
//        System.out.println("this = "+this);
//        System.out.println("This.age = "+this.age);
//        System.out.println("Person(o)"+(Person)o);
//        System.out.println(((Person)o).age);
//
//        if(this.age > ((Person) o).age){
//            return -10;
//        } else if (this.age < ((Person) o). age){
//            return 10;
//        } else {
//            return 0;
//        }
        return this.age-((Person)o).age;
//        return ((Person)o).age - this.age;
    }
}