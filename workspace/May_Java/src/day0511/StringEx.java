package day0511;

public class StringEx {
	// java.lang.String Ŭ���� - ���ڿ� ǥ��
	// String Ŭ�������� ������ Ÿ������ ��� (������ ������ Ÿ��)
	// "�� �̿��� ���ڿ� ǥ��
	// "" :: ���ڿ� "" ::���� => �� ���ڿ��� �ν���.
	
	private static final char[] Str2 = null;

	public static void main(String[] args) {
		String s = "���ڿ� ����";
		System.out.println(s);
		
		String s1 = " ";
		String s2 = "";
		
		System.out.println('A'+1); // 66
		// + ������ String�� �켱���� ����. �ٸ� �����͵� String���� ����
		// abc + 123 �̾�� ����. ��� ������ Type�� String!
		System.out.println("A"+1); // A1 <= (String Type ��ǥ���� ��)		

		// String <= int :: int������+""
		
		String str = 7+"";
		String str1 = ""+7;
		String str2 = " "+7;
		
		String str3 = "" + 7 + 7; //77
		String str4 = 7 + 7 + "";
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
	
	}
}
