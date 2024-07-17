public class Person {
    private String jumin;
    private String passport;

    public Person() {    //기본생성자는 알트+인서트+탭해서 셀렉트논
    }

    public Person(String jumin) {
        this(); //기본 this
        this.jumin = jumin;
    }

    public Person(String jumin, String passport) {
//        this.jumin = jumin;
        this(jumin);    //잘안쓰긴하지만 this 인스턴스 변수
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "jumin='" + jumin + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    public void show() {
        System.out.println("jumin = " + jumin);
        System.out.println("passport = " + passport);
    }
}