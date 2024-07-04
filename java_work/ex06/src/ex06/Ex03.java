package ex06;

import java.util.Iterator;

public class Ex03 {
	
	public static void main(String[] args) {
//for (int i = 2; i < 10; i+=2) 만약 2,4,6 등 짝수단만 보고싶으면 +=2
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if(j==4)
					continue;
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}
}