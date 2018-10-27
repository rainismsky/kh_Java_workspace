package day0516.oop;

public class TvTest {
	public static void main(String[] args) {
		Tv t; //tv클래스로 생성한 객체의 주소값
		t = new Tv();
		//new ::: heap영역에(메모리영역) 주소할당, 공간 생성해서 클래스의 멤버를 인스턴스로 만듦.
		t.ch = 10;
		t.vol = 20;
		
		t.chUp();
		System.out.println("현재 채널은" + t.ch + "입니다.");
	}
}
