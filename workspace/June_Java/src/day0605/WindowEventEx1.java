package day0605;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventEx1 extends Frame implements WindowListener {

	public static void main(String[] args) {
		new WindowEventEx1();

	}
	WindowEventEx1(){
		super("window Event!!");
		
		addWindowListener(this);
		Label l = new Label("window Event Test.",Label.CENTER);
		add(l);
		setBounds(300,300,300,300);
		setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}
	

}
