package day0531.lang;

/*autoboxing�̶�? �׸��� Unboxing��?

Autoboxing����
Integer��
������ int�� �����Ͱ� ���� ���  ,-> �ڵ����� int�� �����͸� Integer������ ��ȯ

Unboxing����
int�� ������ Integer�� �����Ͱ� ���� ��� -> �ڵ����� Integer�� �����͸� int������ ��ȯ
*��ü�������� null�� �ɼ� ������,�⺻�������� null�� ������ ���ٴ°��� ����Ұ�
*/

public class WrapperEx3 {
	public static void main(String[] args) {
		int i = 10;
		
		//�⺻���� ���������� ����ȯ(����ȯ ��������)
		Integer intg=i;
		
		Object obj = i;
		//Object obj = i;
		
		//Object obj = new Integer(i);
		Long lng = 100L; // Long lng = new Long(100L); 
		
		int i2 = intg + 10; //�������� �⺻������ ���� ����
		//i2 = intg.intValue() + 10
		
		long l = intg + lng; //������ ���� ������ ����
		//l = intg.intValue() + lng.longValue()
		
		Integer intg2 = new Integer(20);
		//Long l2 = intg2; //Long l2 = new Integer(20); x
		int l2 = intg + 10; 
		long l3 = intg + lng; //Long l3 = intg2.intValue(); O
		
		System.out.println("i    :" + i);
		System.out.println("intg :" + intg);
		System.out.println("obj  :" + obj);
		System.out.println("lng  :" + lng);
		System.out.println("intg + 10  :" + i2);
		System.out.println("intg + lng :" + l);
		
	}

}
