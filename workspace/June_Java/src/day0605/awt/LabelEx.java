package day0605.awt;

import java.awt.*;

public class LabelEx {
	public static void main(String[] args) {
		Frame f = new Frame("���̺� �׽�Ʈ");
		Panel p = new Panel();
		
		Label label1 = new Label("�������̺�1");
		Label label2 = new Label("�������̺�2",Label.CENTER);
		Label label3 = new Label("�������̺�3",Label.LEFT);
		Label label4 = new Label("�������̺�4",Label.RIGHT);
		
		label1.setBackground(new Color(255,255,0));
		label2.setBackground(Color.lightGray);
		label3.setBackground(Color.lightGray);
		label4.setBackground(Color.lightGray);
		
		p.add(label1);
		p.add(label2);
		p.add(label3);
		p.add(label4);
		
		f.add(p);
		f.setSize(300,100);
		f.setVisible(true);
		
	}
}
