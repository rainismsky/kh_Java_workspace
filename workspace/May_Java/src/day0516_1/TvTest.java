package day0516_1;
public class TvTest {
public static void main(String[] args) {
	Tv t; //Tv클래스로 생성한 객체의 주소값.
	t = new Tv(); 
	
	/*new가 하는 역할은 메모리 공간에 할당받으며 
	 그 공간에 인스턴스 클래스를 만들어줌. 
	new선언시 Tv 타입 뒤에 빈괄호 하고 닫아줘야에러가 안난다*/
	
	/*new ::: heap영역에 주소 할당 
	공간 생성해서 클래스의 멤버를 인스턴스로 만듬.*/

	t.color = "red";
	t.ch = 10;
	t.chUp();
	System.out.println("현재 채널은" +t.ch+ "입니다");
}
}
