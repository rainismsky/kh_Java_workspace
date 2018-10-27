package day0518.oop;

public class MemberCall {
		int in = 10; //인스턴스 변수
		static int cv = 20; //클래스변수
		
		int cv2 = cv;
		//static int cv2 = iv;
		
		static void staticMethod() {} 
		//static 메소드  /static 멤버는 static멤버만 메모리에 올라갈수가 있고
		void method() {} 
		//인스턴스 메소드 /인스턴스는 다 메모리에 올라올수 있다고함 .
		
		public static void main(String[] args) {
					//method(); //나랑 같은 시점에 올라간다면 선언 가능 하다.
		MemberCall mc = new MemberCall();
		mc.method();
		}
		void instanceMethod() { 
			staticMethod();
			method();			
		}
}