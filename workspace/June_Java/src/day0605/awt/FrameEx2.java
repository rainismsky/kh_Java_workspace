package day0605.awt;

import java.awt.*;

public class FrameEx2 extends Frame{
	public FrameEx2() {
		super("프레임 테스트"); //프레임 객체 생성과 같다
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		FrameEx2 fe = new FrameEx2();
	}

}
