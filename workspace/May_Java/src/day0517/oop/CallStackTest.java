package day0517.oop;
public class CallStackTest {

	public static void main(String[] args) {
		firstMethod();

	}
	static void firstMethod() {
		secondMethod();
	}

	static void secondMethod() {
		System.out.println("secondMethod()");		
	}
}

