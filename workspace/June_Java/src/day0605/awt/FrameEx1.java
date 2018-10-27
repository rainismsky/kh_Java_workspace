package day0605.awt;

import java.awt.Frame;

public class FrameEx1 {
	public static void main(String[] args) {
		Frame f= new Frame();
		
		f.setTitle("Frame Test");
		
		f.setSize(300,300);
		f.setResizable(true); //false로 하면 크기변경 불가능
		f.setVisible(true);
	}
}
