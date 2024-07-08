public class BankAcocountMain {

    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();

        // 참조 변수(=클래스 변수, reference variable) 출력 할 때 toString은 생략 가능하다
        // 원래는 주소값(16진수 0~f) 이 나오는데 toString은 내가 다시 정의할 수 있다.

        System.out.println("a 참조변수 = "+a);
        System.out.println("b 참조변수 = "+b);

        a.mod();
        System.out.println();

        System.out.println("a 참조변수 = "+a);
        System.out.println("b 참조변수 = "+b);
    }
}
