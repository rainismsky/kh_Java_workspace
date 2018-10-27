package day0515.forex;

public class ForEx1 {
public static void main(String[] args) {
		
		
		 //for문안에서 선언된 변수는 for문안에서도 밖에서도 선언가능하다.
		
		int i = 0;
		for(int i1=1; i1<=10; i1++) {
			if(i1%2 == 0)
		System.out.println(i1+"번째 수행");
		}
		
		System.out.println("i값:::"+i);
		
		System.out.println();
		//영
		for(int j=2; j<=10; j+=2) {
		System.out.println(j+"번째 수행");
		
	
		
		}
	}

}
