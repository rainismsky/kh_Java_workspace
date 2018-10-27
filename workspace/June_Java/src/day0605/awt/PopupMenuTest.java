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
		
		f.add(pMenu); // PopupMenu�� Frame�� �߰��Ѵ�.
		f.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				 // ������ ���콺��ư�� ������ ��쿡�� PopupMenu�� ȭ�鿡 �����ش�.
				if(me.getModifiers() == MouseEvent.BUTTON3_MASK)
					pMenu.show(f,me.getX(),me.getY()); //show�� Ư���̺�Ʈ���߻������� �����ټ��ֵ��� �����ؾ���
			}
		});
		f.setVisible(true);
	}
}
