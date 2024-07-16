package aa;

public class BBB {

    int num = 10;
    public BBB(){
        System.out.println(num);
        CCC.NUM++;
        System.out.println("CCC.NUM = " + CCC.NUM);
    }
}