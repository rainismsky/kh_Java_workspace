package day0605;

import java.awt.Frame;

public class FrameEx1 {
public static void main(String[] args) {
		Frame f = new Frame();		
		f.setTitle("Frame Test");
		
		f.setSize(300,300);
		f.setResizable(false);
		f.setVisible(true);
	}
}
