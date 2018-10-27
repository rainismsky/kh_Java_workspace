package day0605.awt;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class ChoiceEx {
	public static void main(String[] args) {
		Frame f = new Frame("Choice 테스트");
		Panel p = new Panel();
		
		Choice ch = new Choice();
		
		ch.add("사과");
		ch.addItem("딸기");
		ch.addItem("포도");
		ch.addItem("배");
		
		p.add(ch);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}
