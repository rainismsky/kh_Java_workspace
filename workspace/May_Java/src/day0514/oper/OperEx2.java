package day0514.oper;

public class OperEx2 {
	
	public static void main(String[] args) {
		int a = 12;
		int b = 7;
		
		System.out.println(a+b); //19
		System.out.println(a);
		
		System.out.println(a+=b); 
		System.out.println(a);
	
		a+=b; //�޸𸮿� ���� ���� (�ξ� �� ���� ó���� ����)
		a = a+b; //�޸𸮿� �ִ� ���� �о�ͼ� ���� �� �ٽ� ����
		
	}
}
