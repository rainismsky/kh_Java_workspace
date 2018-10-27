package day0523.oop;

class Card{
	final int NUMBER; //상수지만 선언과 함께 초기화 하지 않고
	final String KIND; //생성자에서 단 한번만 초기화 할 수 있다.
	static int width = 100;
	static int height = 250;
	
	Card(String kind, int num) {
	KIND = kind;
	NUMBER = num;
}

public String toString() {
	return "" + KIND + ""+NUMBER;
}

public class FinalCardTest {
public static void main(String[] args) {
		Card c = new Card("HEART",10); //선언 후 생성자에서 초기화를 시킨다!
		
//c.NUMBER = 5; //error massage!! => cannot assign a value to final variable NUMBER
		
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		
	}
}
}

//변수에 파이널이 붙으면 상수 메서드에 파이널이 붙으면 오버라이딩(x) 클래스에 붙으면 조상(x)