package day0523.oop;

/*�߻� Ŭ���� : �߻�޼��带 �ϳ��� ���� �ִ� Ŭ����
ȥ�ڼ� ���(x),�Ϲ� Ŭ�������� ��� ��, �߻�޼��� �������̵����� �ؼ� ���
*/
abstract class AbstractTest {
	abstract void move();
	
}

class A1 extends AbstractTest{
	
	@Override
	void move() {
		System.out.println("A.move()����!");
		
		
	}
	
}


