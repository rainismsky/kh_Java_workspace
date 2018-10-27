package day0515.forex;

public class ContinueEx1 {
public static void main(String[] args) {
	
	label:
	for(int i = 0 ; i < 10; i++){
		if(i % 4 != 0) { // !=를 넣어주면 4의 배수만 출력 가능함.
			continue label;
			
		}
	System.out.println("i값:"+i);
	
	}
}
}
