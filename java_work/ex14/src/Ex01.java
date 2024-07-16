
class Person {
    private String name;
    private int age;
    public Person(){}
    public Person(String name) {    // 다른 생성자
        this.name = name;
    }

    //행동하는 메서드(함수)
    public void greeting() {
        System.out.println(name + " hello");    //name 앞에 this. 생략되어있음

    }

    public void setName(String name) {
        this.name = name;    // this생략불가. 이 메서드 내의 name이므로
    }

    @Override    //생략가능한 문법, 재정의
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//construcor(생성자)로 private 변수를 바꿀 수 있다.
//setter로 private변수를 바꿀 수 있다.
//다른 생성자 선언시에 기본 생성자 생략 불가 위에 Public Person이 다른생성자임
public class Ex01 {
    public static void main(String[] args) {
        //기본 생성자 선언 후에 setter 로 변수 name 변경
        Person p1 = new Person();
        // name을 바꾸는 다른 생성자로 선언해서
        Person p2 = new Person("박길동");
        p1.setName("홍길동");

        p1.greeting();
        p2.greeting();

        System.out.println(p1);
        System.out.println(p2);
    }
}