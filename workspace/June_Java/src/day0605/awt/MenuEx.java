package day0605.awt;

import java.awt.*;


public class MenuEx extends Frame {
	public MenuEx() {
		super("�޴��׽�Ʈ");
		
		MenuBar mb = new MenuBar();
		
		Menu mnufile = new Menu("����");
		Menu mnucolor = new Menu("����");
		Menu mnuhelp = new Menu("����");
		
		MenuItem mnunew = new MenuItem("������");
		MenuItem mnusave = new MenuItem("����");
		MenuItem mnuopen = new MenuItem("����");
		MenuItem mnuexit = new MenuItem("��!");
		
		mnufile.add(mnunew);
		mnufile.add(mnusave);
		mnufile.add(mnuopen);
		mnufile.addSeparator();
		mnufile.add(mnuexit);
		
		mb.add(mnufile);
		mb.add(mnuhelp);
		mb.add(mnucolor);
		
		setMenuBar(mb);
		
		setSize(200,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MenuEx();
	}
}
