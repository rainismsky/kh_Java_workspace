package day0530.oop;

public class EqualsEx1 {
public static void main(String[] args) {
	
	Value v1 = new Value(10);
	Value v2 = new Value(10);

	if (v1.equals(v2)) { //f
		System.out.println("v1�� v2�� ����.");
	}else {
		System.out.println("v1�� v2�� �޷�.");
	}
	v2 = v1;
	
	if(v1.equals(v2)) { //t
		System.out.println("v1�� v2�� ����.");
	}else {
		System.out.println("v1�� v2�� �޷�.");
	}
}
}

//main
// ==, Object.equals() => ��ü �ּҰ� ��

