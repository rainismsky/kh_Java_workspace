package day0525.oop;
interface InterTest{
	static final int A = 100; //Ű���带 �������ʾƵ� �ڵ����� ����� ���
	abstract int getA(); //Ű���带 �������ʾƵ� �ڵ����� �߻󤱤ļҵ�� ��� ->�������̽����� Ű���� �Ⱥٿ��� �������
}
class InterTestEx implements InterTest{
	public int getA() {
		return A;
	}
	
	public static void main(String[] args) {
		InterTestEx it1 = new InterTestEx();
		System.out.println("getA():" + it1.getA());
	}
}
