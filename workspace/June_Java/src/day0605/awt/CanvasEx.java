package day0605.awt;

import java.awt.*;

public class CanvasEx {
	public static void main(String[] args) {
		Frame f = new Frame("Canvas Å×½ºÆ®");
		
		MyCanvas canvas = new MyCanvas();
		
		canvas.setBackground(Color.yellow);
		
		f.add(canvas);
		f.setSize(200,200);
		f.setVisible(true);
	}
}

class MyCanvas extends Canvas {
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(40,30,100,100); 
	}
	
}
