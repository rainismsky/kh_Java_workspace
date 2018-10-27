package day0524.oop;

public class CastingTest2 {
	public static void main(String args[]) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive(); //drive, Brrrr~출력
		fe = (FireEngine)car; // 에러
		
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
