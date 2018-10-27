package day0516.oop;

class Variables{
	static int cv=1; //클래스변수
	int iv=2; //인스턴스변수
	
	void method() {
		int lv=3; //지역변수
		System.out.println("lv:::" + lv);
	}
}
public class VariablesTest {
	public static void main(String[] args) {
		System.out.println(Variables.cv); //클래스변수는 객체생성하지 않아도 사용가능
		
		Variables v = new Variables();
		System.out.println(v.iv); //인스턴스변수는 객체로 만들어준 이후에 사용가능 
		
		v.method(); //지역변수는 메소드를 실행해야 사용가능
	}
}
