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
void add (int a, int b, int[] result) { //int[] �迭�� �ּҰ��� ������ִ°� ���!
	result[0] = a+b;
} //�޼ҵ尡 ������ ȣ���ߴ� �������� ��ȯ!
}
