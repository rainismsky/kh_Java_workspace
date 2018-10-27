package day0523.oop;

public class PointTest {
public static void main(String[] args) {
	Point3D p3 = new Point3D(1,2,3);
	}
}

class Point extends Object{
	int x;
	int y;
	
	Point(int x, int y){
		super(); // 조상 Object();
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x:"+x+",y:"+y;
}
}

class Point3D extends Point{ //개별멤버만 내가 초기화함 초기화가 포인트클래스와 중첩됬었기 때문! 
	int z;
	
	Point3D(int x ,int y ,int z){
		super(x,y); //Point();
		
		/*this.x=x;
		this.y=y;*/ 	//super의 멤버는 super생성자에서 초기화
		
		this.z = z;//sub의 멤버는 sub생성자에서 초기화
	}
	
	String getLocation() { //오버라이딩
		return "x:"+x+",y:"+y+",z:"+z;
	}	
}