package day0605.awt;

import java.awt.*;

public class FrameEx1 {
	public static void main(String args[]) {
		Frame f = new Frame();

		f.setTitle("Frame Test");

		f.setSize(300, 300);
		f.setResizable(false);
		f.setVisible(true);
	}
}