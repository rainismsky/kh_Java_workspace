package day0515.forex;

public class ContinueEx1 {
public static void main(String[] args) {
	
	label:
	for(int i = 0 ; i < 10; i++){
		if(i % 4 != 0) { // !=�� �־��ָ� 4�� ����� ��� ������.
			continue label;
			
		}
	System.out.println("i��:"+i);
	
	}
}
}
