package day0516.oop;

public class TvTest {
	public static void main(String[] args) {
		Tv t; //tvŬ������ ������ ��ü�� �ּҰ�
		t = new Tv();
		//new ::: heap������(�޸𸮿���) �ּ��Ҵ�, ���� �����ؼ� Ŭ������ ����� �ν��Ͻ��� ����.
		t.ch = 10;
		t.vol = 20;
		
		t.chUp();
		System.out.println("���� ä����" + t.ch + "�Դϴ�.");
	}
}
