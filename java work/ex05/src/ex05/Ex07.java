package ex05;

public class Ex07 {
	public static void main(String[] args) {
		
		int num = 0;
		while((num++)<100) {
			if(num%5!=0 || num%7!=0)	
				//나머지가 0이 아니면 컨티뉴 진행. 0이면 조건이안맞으니 컨티뉴로 안돌아가고 출력이됨
				continue;
			System.out.println("num = "+num);
		}
	}

}
