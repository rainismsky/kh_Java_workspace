package day0529.oop;

import java.awt.*;
import java.awt.event.*;

public class InnerEx7 {
	public static void main(String args[]) {
		Frame f = new Frame();
		Button b = new Button("Start");
		f.add(b);
		b.addActionListener(new HandlerEx());
		f.setBounds(200,200,300,300);
		f.setVisible(true);
	}
}
class HandlerEx implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!!!");
	}
}
