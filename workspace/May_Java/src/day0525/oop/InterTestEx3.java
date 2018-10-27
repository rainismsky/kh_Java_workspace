package day0525.oop;

import java.util.Scanner;

interface Say{
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
		Say s;
		String lang = new Scanner(System.in).next();
		
		if(lang.equals("e")) { //문자열비교 메소드 equals
			s = e;
		}else if(lang.equals("k")) {
			s = k;
		}else {
			s = et;
		}
		
		s.Hello();
	}
}
