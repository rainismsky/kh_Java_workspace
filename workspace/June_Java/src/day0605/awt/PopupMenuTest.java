package day0605.awt;

import java.awt.*;
import java.awt.event.*;

public class PopupMenuTest {
	public static void main(String[] args) {
		final Frame f = new Frame("PopupMenu Test");
		f.setSize(300,200);
		
		final PopupMenu pMenu = new PopupMenu("Edit");
		MenuItem miCut = new MenuItem("Cut");
		MenuItem miCopy = new MenuItem("Copy");
		MenuItem miPaste = new MenuItem("Paste");
		pMenu.add(miCut);
		pMenu.add(miCopy);
		pMenu.add(miPaste);
		
		f.add(pMenu); // PopupMenu를 Frame에 추가한다.
		f.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				 // 오른쪽 마우스버튼을 누르는 경우에만 PopupMenu를 화면에 보여준다.
				if(me.getModifiers() == MouseEvent.BUTTON3_MASK)
					pMenu.show(f,me.getX(),me.getY()); //show로 특정이벤트가발생했을때 보여줄수있도록 지정해야함
			}
		});
		f.setVisible(true);
	}
}
