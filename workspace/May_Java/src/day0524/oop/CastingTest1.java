package day0524.oop;

public class CastingTest1 {
	public static void main(String args[]) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water(); //water!!!출력
		car = fe; //Car car = new Fe(); Car로부터 물려받은 stop까지의 멤버만 사용가능
		//car.water();
		fe2 = (FireEngine)car;
		fe2.water();
	}
}

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrr~~");
	}
	
	void stop() {
		System.out.println("stop!!");
	}
}

class FireEngine extends Car{
	void water() {
		System.out.println("Water!!!");
	}
}