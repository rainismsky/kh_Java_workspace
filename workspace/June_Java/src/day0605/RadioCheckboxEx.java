package day0605;

import java.awt.*;

public class RadioCheckboxEx {

		public static void main(String args[]) {
			Frame f = new Frame("������ üũ�ڽ� �׽�Ʈ");
			Panel p = new Panel();
			Panel p1 = new Panel();
			Panel p2 = new Panel();
			
			CheckboxGroup group = new CheckboxGroup();
			Checkbox radio1 = new Checkbox("����",group,false);
			Checkbox radio2 = new Checkbox("��������",group,false);
			Checkbox radio3 = new Checkbox("����",group,false);
			
			CheckboxGroup group1 = new CheckboxGroup();
			Checkbox radio4 = new Checkbox("��",group,false);
			Checkbox radio5 = new Checkbox("��",group,false);
		
			p1.add(radio4);
			p1.add(radio5);
			
			p1.add(radio1);
			p1.add(radio2);
			p1.add(radio3);
			
			p2.add(p);
			p2.add(p1);
			
			f.add(p2);
			f.setSize(300, 100);
			f.setVisible(true);
			
		}
	}


