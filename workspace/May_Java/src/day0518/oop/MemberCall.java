package day0518.oop;

public class MemberCall {
		int in = 10; //�ν��Ͻ� ����
		static int cv = 20; //Ŭ��������
		
		int cv2 = cv;
		//static int cv2 = iv;
		
		static void staticMethod() {} 
		//static �޼ҵ�  /static ����� static����� �޸𸮿� �ö󰥼��� �ְ�
		void method() {} 
		//�ν��Ͻ� �޼ҵ� /�ν��Ͻ��� �� �޸𸮿� �ö�ü� �ִٰ��� .
		
		public static void main(String[] args) {
					//method(); //���� ���� ������ �ö󰣴ٸ� ���� ���� �ϴ�.
		MemberCall mc = new MemberCall();
		mc.method();
		}
		void instanceMethod() { 
			staticMethod();
			method();			
		}
}