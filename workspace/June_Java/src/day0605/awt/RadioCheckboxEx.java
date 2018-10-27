package day0605.awt;

import java.awt.*;


public class RadioCheckboxEx {
	public static void main(String[] args) {
		Frame f = new Frame("라디오형 체크박스 테스트");
		Panel p = new Panel();
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox radio1 = new Checkbox("중졸",group,false);
		Checkbox radio2 = new Checkbox("전문대졸",group,false);
		Checkbox radio3 = new Checkbox("대졸",group,true);
		
		CheckboxGroup group1 = new CheckboxGroup();
		Checkbox radio4 = new Checkbox("여자",group1,false);
		Checkbox radio5 = new Checkbox("남자",group1,false);
		
		p1.add(radio4);
		p1.add(radio5);
		
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		
		p2.add(p);
		p2.add(p1);
		
		f.add(p2);
		f.setSize(300, 100);
		f.setVisible(true);
		
	}
}
