package bank;

public class BackAccountMain {

//    public static void checkMyBalance(){
//    }

    public static void main(String[] args) {
        System.out.println("시작");

        //constructor
        BankAccount park = new BankAccount("박길동", "1234", "850511", 5000);
        BankAccount yoon = new BankAccount("윤길동", "4567", "950511", 5000);
//        park.initAccount("1234", "850511", 5000);
//        yoon.initAccount("4567", "950511", 5000);

        park.cmb();
        yoon.cmb();

        park.deposit(3000);
        yoon.deposit(4000);

        park.cmb();
        yoon.cmb();

        park.withdraw(1000);
        yoon.withdraw(2000);

        park.cmb();
        yoon.cmb();

        System.out.println("끝");
    }
}