package day0605.awt;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class ChoiceEx {
	public static void main(String[] args) {
		Frame f = new Frame("Choice �׽�Ʈ");
		Panel p = new Panel();
		
		Choice ch = new Choice();
		
		ch.add("���");
		ch.addItem("����");
		ch.addItem("����");
		ch.addItem("��");
		
		p.add(ch);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}
