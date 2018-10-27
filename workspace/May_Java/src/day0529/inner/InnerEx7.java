package day0529.inner;

import java.awt.*;
import java.awt.event.*;

public class InnerEx7 {
	public static void main(String[] args) {
		Frame f = new Frame();
		Button b = new Button("Start");
		b.addActionListener(new HandlerEx());
		f.add(b);
		f.setBounds(200,200,300,300);
		f.setVisible(true);
	}
}

class HandlerEx implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!!");
	}
}
