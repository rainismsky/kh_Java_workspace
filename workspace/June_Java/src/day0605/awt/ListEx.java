package day0605.awt;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class ListEx {
	public static void main(String[] args) {
		Frame f = new Frame("����Ʈ �׽�Ʈ");
		Panel p = new Panel();
		
		List list1 = new List(3);
		
		list1.add("����");
		list1.add("����");
		list1.add("�뱸");
		list1.add("�λ�");
		list1.add("���");
		list1.add("����");
		list1.add("��â");
		list1.add("��õ");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300, 100);
		f.setVisible(true);
	}
}
