package bank;

public class BankAccount {
    int num = 0;

    //cmb = checkMyBalance, num=balance
    public int cmb() {

        System.out.println("잔액 " + num);      // 가까이있는 int num = 200;을 가져옴
//      System.out.println("잔액 " + this.num); // 맨위에있는 int num = 0;을 가져옴
        return num;
    }

    public void deposit(int a) {
        num += a;
    }

    public void withdraw(int a) {
        num -= a;
    }
}
