package day0605.awt;

import java.awt.*;


public class MenuEx extends Frame {
	public MenuEx() {
		super("메뉴테스트");
		
		MenuBar mb = new MenuBar();
		
		Menu mnufile = new Menu("파일");
		Menu mnucolor = new Menu("색상");
		Menu mnuhelp = new Menu("도움말");
		
		MenuItem mnunew = new MenuItem("새파일");
		MenuItem mnusave = new MenuItem("저장");
		MenuItem mnuopen = new MenuItem("열기");
		MenuItem mnuexit = new MenuItem("끝!");
		
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
