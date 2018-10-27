package day0521.oop;
class Tv{
	boolean power; //전원상태(on/off)
	int channel; //채널

	void power() { power = !power;}
	void channelUp() {++ channel;}
	void channelDown() { --channel; }
	//현재 전원 상태 ,채널 상태 출력하라!
	//void 선언하는 이유 : 리턴하는 값이 없을때 기본자료형 대신 void선언한다!!
	
	
public String toString() {
return "전원상태:"+power+" 현재 채널:"+channel;
}

}
class CaptionTv extends Tv{
	CaptionTv(){}
	boolean caption; //캡션상태 (on/off(
	void displayCaption(String text) { //텍스트 주소값을 밑에 텍스트에 전달
		if (caption) { //캡션 상태가 on(true)일 때만 text를 보여 준다.
			System.out.println(text);
		}
	}
}

public class CaptionTvTest {
public static 
void main(String[] args) {
	Tv t = new Tv();
	System.out.println(t);
	
	CaptionTv ctv = new CaptionTv(); //조상 클래스로부터 상속받은 멤버
	ctv.channel = 10; 				// 조상 클래스로부터 상속받은 멤버
	ctv.channelUp();
	System.out.println(ctv.channel);
	ctv.displayCaption("Hello, world"); //캡션 기능을 켠다.
	ctv.caption = true;
	ctv.displayCaption("Hello, World"); // 캡션을 화면에 보여 준다.
}
}
