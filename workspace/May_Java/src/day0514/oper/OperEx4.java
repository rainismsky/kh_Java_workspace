package day0514.oper;

public class OperEx4 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		boolean c = !((a+=12)>b) && ( a == (b+2));
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//*************���� ���� �߿��� �����ڵ�***************************
		// && �־��� ��� ���� ��ġ(true)�Ҷ� ���.
		//true�϶� �������� ���������� false�϶� �������� �ʴ´�.
		
		// || �ϳ��� ��ġ(true)�϶� ���.
		// true�� �������� �������� �ʴ´�. false�϶� �������ش�.
		
		// ! ����(true)�� ����(false)���� ������ ���Ƿ� ó����. 
		//(!�� true,false�տ��� �ٿ��� ���� �ִ�.)
		
	}

}
