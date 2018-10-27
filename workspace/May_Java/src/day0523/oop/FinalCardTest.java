package day0523.oop;

class Card{
	final int NUMBER; //������� ����� �Բ� �ʱ�ȭ ���� �ʰ�
	final String KIND; //�����ڿ��� �� �ѹ��� �ʱ�ȭ �� �� �ִ�.
	static int width = 100;
	static int height = 250;
	
	Card(String kind, int num) {
	KIND = kind;
	NUMBER = num;
}

public String toString() {
	return "" + KIND + ""+NUMBER;
}

public class FinalCardTest {
public static void main(String[] args) {
		Card c = new Card("HEART",10); //���� �� �����ڿ��� �ʱ�ȭ�� ��Ų��!
		
//c.NUMBER = 5; //error massage!! => cannot assign a value to final variable NUMBER
		
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		
	}
}
}

//������ ���̳��� ������ ��� �޼��忡 ���̳��� ������ �������̵�(x) Ŭ������ ������ ����(x)