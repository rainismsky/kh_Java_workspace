package day0531.lang;

public class StringEx5 {

	
		static String s; //null
		static String s2 = ""; 	//���ڿ� ����ȭ 
						//StringŸ���� �׻� ���ڿ��� �ʱ�ȭ ���Ѽ� ���� ������ ������ !
	
		public static void main(String args[]) {
			for(int i = 1;i <10; i++) {
				s += i; //s=s+i;
				s2 += i;
			}
			System.out.println(s);	//null123456789
			System.out.println(s2);
		}

}
