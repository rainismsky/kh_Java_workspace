package day0517.oop;
public class ReturnTest {
public static void main(String[] args) {
	ReturnTest r = new ReturnTest();
	
	int result = r.add(3,5);
	System.out.println(result);
	
	int[] result2 = {0};
	r.add(3,5,result2);
	System.out.println(result2 [0]);
	
}
int add (int a , int b) {
	return a+b;
}
void add (int a, int b, int[] result) { //int[] 배열의 주소값을 저장되있는거 기억!
	result[0] = a+b;
} //메소드가 끝나면 호출했던 지점으로 귀환!
}
