package day0601;
import java.util.*; 

public class ArrayListEx2 {
	public static void main(String[] args) { 
		final int LIMIT = 10;	// �ڸ����� �ϴ� ������ ������ �����Ѵ�.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ"; //����43
		int length = source.length(); 
		

		List<String> list = new ArrayList<String>(length/LIMIT + 10); // ũ�⸦ �ణ ���� �ְ� ��´�.
												//43/10 �� 4�ε�  �����Ӱ� 10�� �����༭ ����
		for(int i=0; i < length; i+=LIMIT) { 
			if(i+LIMIT < length ) //length���� ������ ó��
				list.add(source.substring(i, i+LIMIT));  //ex_i��0�϶�) 0���� 10���ε������� �߶� list�� ����
			else 
				list.add(source.substring(i)); 
		} 

		for(int i=0; i < list.size(); i++) { 
			System.out.println(list.get(i)); 
		} 
	} // main()
}
//�����ö��� get���� �ε��� �����ؼ� ������
//list�� ���Ҷ��� add�� addelement
