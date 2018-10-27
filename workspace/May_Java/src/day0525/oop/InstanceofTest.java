package day0525.oop;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		Car car = new Car();
		
		if(car instanceof FireEngine) { //Super인 Car가 Sub인 FireEngine으로 형변환 가능
			System.out.println("This is a Car instance.");
		}
		if(fe instanceof FireEngine) { 
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car) { //sub인 fe가 super인 Car로 형변환 불가
			System.out.println("This is an Object instance.");
		}
	}
}

class Car{}
class FireEngine extends Car{}
