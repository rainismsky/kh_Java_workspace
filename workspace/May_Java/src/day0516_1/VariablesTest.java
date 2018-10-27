package day0516_1;

//public class는 하나의 파일에 하나만 존재해야한다.
//main()가 있는 클래스명 == 파일명
class Variables{
	static int cv = 10000;//class or static 변수
	int iv = 2000; // instance 변수
	void method() {
		int lv = 300;// 지역변수
		System.out.println("ln:::"+lv);
	}
}
public class VariablesTest{ 
public static void main(String[] args) {
	System.out.println("cv:::" +Variables.cv);
	// class 변수는 객체생성 하지 않아도 사용 가능
	Variables v = new Variables();
	System.out.println("iv:::"+ v.iv);
	
	//인스턴스 변수는 객체 생성해야 생성 가능
	v.method();
}
	}


