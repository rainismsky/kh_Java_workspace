package day0518.oop;

class Car2{
	String color; //색상
	String gearType; //변속기 종류 - auto(자동),manual(수동)
	int door; //문의 개수 //static int door;

Car2(){
	this("white","auto",4);
}
Car2(String color){
	this(color,"auto",4);
}
Car2(String color,String gearType,int door){
	this.color = color;
	this.gearType = gearType;
	this.door = door;
//this참조변수 : 지역변수와 인스턴스 변수의 이름이 같으면 지역변수가 우선권을 가져.
//this 참조변수에 현재 객체의 주소값을 저장해 인스턴스 변수를 가리킨다.
}
}

class CarTest2{
public static void main(String[] args) {
	Car2 c1 = new Car2();
	Car2 c2 = new Car2("blue");
	
	System.out.println("c1의 color="+c1.color+",gearType="+c1.gearType+",door="+c1.door);
	System.out.println("c2의 color="+c2.color+",gearType="+c2.gearType+",door="+c2.door);	

	}

}
