package day0531.lang;

public class StringEx3 {
	public static void main(String[] args) {
		String s1 = "AAA";
		String s2 = new String("AAA");
		
		if(s1 == s2) {
			System.out.println("s1==s2 ? true");
		}else {
			System.out.println("s1==s2 ? true");
		}
		s2 = s2.intern(); //������ ������� ������ ��ü�� constance pool�� ���
		System.out.println("s2�� intern()�� ȣ���� ��");
		
		if(s1 == s2) {
			System.out.println("s1==s2 ? true");
		}else {
			System.out.println("s1==s2 ? true");
		}
		

	}

}
