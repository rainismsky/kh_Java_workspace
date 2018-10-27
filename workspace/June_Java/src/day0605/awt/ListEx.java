package day0605.awt;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class ListEx {
	public static void main(String[] args) {
		Frame f = new Frame("리스트 테스트");
		Panel p = new Panel();
		
		List list1 = new List(3);
		
		list1.add("서울");
		list1.add("대전");
		list1.add("대구");
		list1.add("부산");
		list1.add("울산");
		list1.add("강릉");
		list1.add("평창");
		list1.add("인천");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300, 100);
		f.setVisible(true);
	}
}
