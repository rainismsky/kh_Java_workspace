package day0516.oop;

class Variables{
	static int cv=1; //Ŭ��������
	int iv=2; //�ν��Ͻ�����
	
	void method() {
		int lv=3; //��������
		System.out.println("lv:::" + lv);
	}
}
public class VariablesTest {
	public static void main(String[] args) {
		System.out.println(Variables.cv); //Ŭ���������� ��ü�������� �ʾƵ� ��밡��
		
		Variables v = new Variables();
		System.out.println(v.iv); //�ν��Ͻ������� ��ü�� ������� ���Ŀ� ��밡�� 
		
		v.method(); //���������� �޼ҵ带 �����ؾ� ��밡��
	}
}
