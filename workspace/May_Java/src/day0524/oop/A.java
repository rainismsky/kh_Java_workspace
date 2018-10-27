package day0524.oop;

public class A {
	private A() {};
	
	static A a = new A();

	public static A getInstance() {
		return a;
	}
}
