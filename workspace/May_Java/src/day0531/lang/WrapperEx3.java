package day0531.lang;

/*autoboxing이란? 그리고 Unboxing란?

Autoboxing과정
Integer형
변수에 int형 데이터가 들어올 경우  ,-> 자동으로 int형 데이터를 Integer형으로 변환

Unboxing과정
int형 변수에 Integer형 데이터가 들어올 경우 -> 자동으로 Integer형 데이터를 int형으로 변환
*객체형에서는 null이 될수 있지만,기본형에서는 null이 있을수 없다는것을 명심할것
*/

public class WrapperEx3 {
	public static void main(String[] args) {
		int i = 10;
		
		//기본형을 잠초형으로 형변환(형변환 생략가능)
		Integer intg=i;
		
		Object obj = i;
		//Object obj = i;
		
		//Object obj = new Integer(i);
		Long lng = 100L; // Long lng = new Long(100L); 
		
		int i2 = intg + 10; //참조형과 기본형간의 연산 가능
		//i2 = intg.intValue() + 10
		
		long l = intg + lng; //잠초형 간의 덧셈도 가능
		//l = intg.intValue() + lng.longValue()
		
		Integer intg2 = new Integer(20);
		//Long l2 = intg2; //Long l2 = new Integer(20); x
		int l2 = intg + 10; 
		long l3 = intg + lng; //Long l3 = intg2.intValue(); O
		
		System.out.println("i    :" + i);
		System.out.println("intg :" + intg);
		System.out.println("obj  :" + obj);
		System.out.println("lng  :" + lng);
		System.out.println("intg + 10  :" + i2);
		System.out.println("intg + lng :" + l);
		
	}

}
