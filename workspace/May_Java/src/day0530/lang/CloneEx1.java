package day0530.lang;

class Point implements Cloneable{ //cloneable�������̽��� �����ϴ°� �����ε� clone()�� ȣ���� �� �ִ�
	//�������� �ʰ� clone()�� ȣ���ϸ� ���ܰ� �߻��Ѵ�
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
	public Point clone() { //Object�� clone()�� �������̵��ϴ� �� pointŸ������ ����
		Object obj = null;
		try {
			obj = super.clone(); //cloneable�� clone�� ȣ���ϱ����� super�� ����
		}catch(CloneNotSupportedException e) {}
		
		return(Point)obj; //pointŸ������ return�ؾ��ؼ� ������Ʈ���� point�� ��������ؼ� (point)��� ������� 
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
