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
		super(); // ���� Object();
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x:"+x+",y:"+y;
}
}

class Point3D extends Point{ //��������� ���� �ʱ�ȭ�� �ʱ�ȭ�� ����ƮŬ������ ��ø����� ����! 
	int z;
	
	Point3D(int x ,int y ,int z){
		super(x,y); //Point();
		
		/*this.x=x;
		this.y=y;*/ 	//super�� ����� super�����ڿ��� �ʱ�ȭ
		
		this.z = z;//sub�� ����� sub�����ڿ��� �ʱ�ȭ
	}
	
	String getLocation() { //�������̵�
		return "x:"+x+",y:"+y+",z:"+z;
	}	
}