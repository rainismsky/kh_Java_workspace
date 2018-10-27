package day0530.lang;

class Point implements Cloneable{ //cloneable인터페이스를 구현하는것 만으로도 clone()을 호출할 수 있다
	//구현하지 않고 clone()을 호출하면 예외가 발생한다
	int x;
	int y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x=" + x+",y=" +y;
	}
	
	@Override
	public Point clone() { //Object의 clone()을 오버라이딩하는 것 point타입으로 리턴
		Object obj = null;
		try {
			obj = super.clone(); //cloneable의 clone을 호출하기위해 super를 붙임
		}catch(CloneNotSupportedException e) {}
		
		return(Point)obj; //point타입으로 return해야해서 오브젝트에서 point로 내려줘야해서 (point)라고 명시해줌 
	}
}
public class CloneEx1 {
	public static void main(String[] args) {
		Point original = new Point(3,5);
		Point copy = original.clone();
		System.out.println(original);
		System.out.println(copy);
		copy.x=10;
		System.out.println(original);
		System.out.println(copy);
	}
}
