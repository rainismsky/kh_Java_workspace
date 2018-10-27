package day0523.oop;

public class SuperTest2 {

	public static void main(String[] args) {
		Child1 c = new Child1();
		c.method();
	}
}

class Parent1{
	int x = 10; //변수 재정의 , 물려 받은 변수를 재정의 해서 사용가능!!
}

class Child1 extends Parent1{
	int x = 20; //변수 재정의
	
	void method() {
		System.out.println("x="+x);
		System.out.println("this.x=" + this.x);
		System.out.println("super.x="+super.x);
	}
}
