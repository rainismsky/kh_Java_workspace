package day0516_1;

//public class�� �ϳ��� ���Ͽ� �ϳ��� �����ؾ��Ѵ�.
//main()�� �ִ� Ŭ������ == ���ϸ�
class Variables{
	static int cv = 10000;//class or static ����
	int iv = 2000; // instance ����
	void method() {
		int lv = 300;// ��������
		System.out.println("ln:::"+lv);
	}
}
public class VariablesTest{ 
public static void main(String[] args) {
	System.out.println("cv:::" +Variables.cv);
	// class ������ ��ü���� ���� �ʾƵ� ��� ����
	Variables v = new Variables();
	System.out.println("iv:::"+ v.iv);
	
	//�ν��Ͻ� ������ ��ü �����ؾ� ���� ����
	v.method();
}
	}


