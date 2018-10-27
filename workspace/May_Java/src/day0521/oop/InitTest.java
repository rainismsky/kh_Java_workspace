package day0521.oop;
public class InitTest {
	
static int cv = 10;//스테틱변수
int iv; //인스턴스 변수
void method() { //인스턴스 변수
int lv;

//System.out.println(lv); 지역변수는 자동초기화가 안되기 때문에 직접 초기화해서 써야함.
}
//지역변수

public static void main(String[] args) {
System.out.println("lv:::"+InitTest.cv); // 같은 클래스라서 클래스명 선택
InitTest init = new InitTest();
System.out.println("iv::::"+init.iv);
System.out.println("iv::::"+init.cv);
}
}


