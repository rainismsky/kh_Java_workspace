package day0525.oop;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		Car car = new Car();
		
		if(car instanceof FireEngine) { //Super�� Car�� Sub�� FireEngine���� ����ȯ ����
			System.out.println("This is a Car instance.");
		}
		if(fe instanceof FireEngine) { 
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car) { //sub�� fe�� super�� Car�� ����ȯ �Ұ�
			System.out.println("This is an Object instance.");
		}
	}
}

class Car{}
class FireEngine extends Car{}
