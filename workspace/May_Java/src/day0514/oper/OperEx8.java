package day0514.oper;

public class OperEx8 {
	public static void main(String[] args) {
		int a = 15;
		int b = 16;
		String s = "";
		
		s+= a>b ? (a-b)+"��ŭ a�� ũ��." : (b-a)+"��ŭ b�� ũ��.";
		
		System.out.println(s);
	}
}
