package day0525;
import java.util.Scanner;

interface Say{ //추상클래스보단 인터페이스를 자주써욧!
	public void Hello();
}

class Korean implements Say{
	@Override
	public void Hello() {
		System.out.println("안녕");
	}
}

class English implements Say{
	@Override
	public void Hello() {
		System.out.println("Hello");
	}
}

class Etc implements Say{
	@Override
	public void Hello() {
		System.out.println("Hi~~");
	}
}

public class InterTestEx3 {
public static void main(String[] args) {
		Korean k = new Korean();
		English e = new English();
		Etc et = new Etc();
		Say s; //슈퍼타입 변수 선언
		String lang = new Scanner(System.in).next(); 
		//화면과 연결된 통로(콘솔)과 연결(System.in)
		
		if(lang.equals("e")) {
			s = e;
		}else if(lang.equals("k")) {
			s = k;
		}else {
			s = et;
		}
		s.Hello();
	}		
	}
