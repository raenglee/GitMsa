class BB {
    int num = 10;
}

class CC {
    public void doA(BB b) {
        System.out.println("b.num = " + b.num);
        b.num = 30;
    }
}

public class Ex04 {


    public static void main(String[] args) {

        BB bb = new BB();
        CC cc = new CC();

        cc.doA(bb);
        System.out.println("bb.num = "+bb.num);

        bb = null;

    }
}
