package org.example;

import java.util.function.ToIntBiFunction;

class IBox{
    private  int n;
    public IBox(int n) {
        this.n = n;
    }

    public int lager(IBox b){
        if(n>b.n)
            return n;
        else
            return b.n;
    }
}

public class Ex02 {

    public static void main(String[] args) {
//        ToIntBiFunction<IBox, IBox> toIntBiFunction = (iBox, iBox2) -> iBox.lager(iBox2);
        ToIntBiFunction<IBox, IBox> toIntBiFunction = IBox::lager;
        int result = toIntBiFunction.applyAsInt(new IBox(5),new IBox(7));

        System.out.println("result = "+result);
    }
}
