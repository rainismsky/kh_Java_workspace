package day0514.oper;

public class OperEx4 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		boolean c = !((a+=12)>b) && ( a == (b+2));
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//*************많이 쓰는 중요한 연산자들***************************
		// && 주어진 모든 값이 일치(true)할때 사용.
		//true일땐 후조건을 실행하지만 false일땐 실행하지 않는다.
		
		// || 하나라도 일치(true)일때 사용.
		// true면 후조건을 실행하지 않는다. false일땐 실행해준다.
		
		// ! 진실(true)을 거짓(false)으로 거짓은 진실로 처리함. 
		//(!는 true,false앞에만 붙여서 쓸수 있다.)
		
	}

}
