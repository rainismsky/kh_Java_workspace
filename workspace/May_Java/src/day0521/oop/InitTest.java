package day0521.oop;
public class InitTest {
	
static int cv = 10;//����ƽ����
int iv; //�ν��Ͻ� ����
void method() { //�ν��Ͻ� ����
int lv;

//System.out.println(lv); ���������� �ڵ��ʱ�ȭ�� �ȵǱ� ������ ���� �ʱ�ȭ�ؼ� �����.
}
//��������

public static void main(String[] args) {
System.out.println("lv:::"+InitTest.cv); // ���� Ŭ������ Ŭ������ ����
InitTest init = new InitTest();
System.out.println("iv::::"+init.iv);
System.out.println("iv::::"+init.cv);
}
}


