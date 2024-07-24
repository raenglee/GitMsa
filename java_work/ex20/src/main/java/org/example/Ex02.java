package org.example;

class Board{}
class PBoard extends Board{}

public class Ex02 {
    public static void main(String[] args) {

        //실행 중 에러
        Board board = new PBoard();
        PBoard pBoard = (PBoard) new Board();

        //미리 에러를 가르쳐줌
//        System.out.println();

        System.out.println("success");
    }
}