package day0531.lang;
//int -> String

class StringEx7 {

	public static void main(String[] args) {
		int Value = 100;
		String strValue = String.valueOf("value"); //int�� String���� ��ȯ! /valueOf:����Ÿ�� ������ �� �޾ƿͼ� ��ü�� ��ȯ
		
		int value2 = 100;
		String strValue2 = value2 + ""; //int�� String���� ��ȯ�ϴ� �� �ٸ� ���
		
		System.out.println(strValue);
		System.out.println(strValue2);
	}

}
