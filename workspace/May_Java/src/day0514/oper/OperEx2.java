package day0514.oper;

public class OperEx2 {
	
	public static void main(String[] args) {
		int a = 12;
		int b = 7;
		
		System.out.println(a+b); //19
		System.out.println(a);
		
		System.out.println(a+=b); 
		System.out.println(a);
	
		a+=b; //메모리에 직접 연산 (훨씬 더 빠른 처리가 가능)
		a = a+b; //메모리에 있는 값을 읽어와서 연산 후 다시 저장
		
	}
}
