package day0518.oop;
class Data1{
	int value; //�⺻ ������.
}
class Data2{
	int value;
	Data2(int x) {
		value = x;
	}
}
public class ConstructorTest {
	ConstructorTest(){}
	public static void main(String[] args) {
	Data1 d1 = new Data1(); //Compile error�߻�
	
	Data2 d2; 
	Data2 d3 = new Data2(30); //Compile error�߻�
}
}


