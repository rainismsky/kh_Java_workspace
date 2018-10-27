package day0530.oop;

public class EqualsEx1 {
public static void main(String[] args) {
	
	Value v1 = new Value(10);
	Value v2 = new Value(10);

	if (v1.equals(v2)) { //f
		System.out.println("v1과 v2는 같어.");
	}else {
		System.out.println("v1과 v2는 달러.");
	}
	v2 = v1;
	
	if(v1.equals(v2)) { //t
		System.out.println("v1과 v2는 같다.");
	}else {
		System.out.println("v1과 v2는 달러.");
	}
}
}

//main
// ==, Object.equals() => 객체 주소값 비교

