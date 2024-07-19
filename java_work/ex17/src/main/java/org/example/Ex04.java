package org.example;

import org.example.box.Box;
import org.example.box.GoldBox;
import org.example.box.PaperBox;

public class Ex04 {
    public static void main(String[] args) {
        Box box1 = new Box();
        PaperBox box2 = new PaperBox();
        GoldBox box3 = new GoldBox();

        wrapBox(box1);
        wrapBox(box2);
        wrapBox(box3);

    }
    public static void wrapBox(Box box){
        if(box instanceof GoldBox)
            ((GoldBox) box).goldbox();    //GoldBox로 형변환해서 쓰는것 박스클래스엔 박스뿐이라 함수호출 불가능
        else if(box instanceof PaperBox)
            ((PaperBox) box).paperbox();
        else
            box.box();
    }
}