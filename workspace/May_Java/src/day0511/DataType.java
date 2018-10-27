package day0511;

public class DataType {

		public static void main(String[] args) {
		
		boolean b; //boolean 데이터를 저장할수 있는 공간 선언
		b = true; // b에 true룰 대입한다.(저장한다.)
		boolean b1 = false; //선언과 값을 대입하는 것을 동시에 가능하다.
		System.out.println("b가 갖고 있는 값:::"+b);
		System.out.println("b1가 갖고 있는 값:::"+b1);
		
		char c = 'A';
		char c1 = 65; 
		// char(캐릭터)문에 숫자를 저장하는 경우 아스키코드표에 의해 문자로 변경뒤 저장
		System.out.println("c:"+ c); // A
		System.out.println("c::"+ c1); // A 

		int i = 100; //100은 정수형의 기본 int형 type
		long l = 10L; //정수 뒤에 접미사 1/L을 붙여 long 타입 데이터임을 명시.
	
		double d = 3.14;
		float f = 3.14F; // 실수 뒤에 접미사 F/f를 붙여서 float타입 데이터임을 명시.
						 // 실수는 double타입
		float f1 = 100F;
		System.out.println("f1:"+f1);
		
		// F라는 접두어가 있다면 D도 제공됨 정수 뒤에 D/d를 붙여서 double 타입 데이터임을 명시.
		
		
		
		
	}
}