package day0523.oop;

/*추상 클래스 : 추상메서드를 하나라도 갖고 있는 클래스
혼자서 사용(x),일반 클래스에서 상속 후, 추상메서드 오버라이딩까지 해서 사용
*/
abstract class AbstractTest {
	abstract void move();
	
}

class A1 extends AbstractTest{
	
	@Override
	void move() {
		System.out.println("A.move()실행!");
		
		
	}
	
}


