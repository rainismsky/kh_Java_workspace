package day0518.oop;

class Car4{////메소드
	String color;
	String gearType;
	int door;
	
	void CarType(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}

}
class CarTestMethod {
	public static void main(String[] args) {
		Car4 ct = new Car4();
		ct.CarType("White", "auto", 4);
		
		System.out.println("ct의 color=" + ct.color+ ", gearType=" + ct.gearType + ", door=" + ct.door);
	}
}
