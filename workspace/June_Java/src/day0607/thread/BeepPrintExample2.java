package day0607.thread;
import java.awt.Toolkit;
public class BeepPrintExample2 {
	

	public static void main(String[] args) {
	//how1
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		
		thread.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("¶ò!!!!!!!!!!!");
			try {Thread.sleep(500);}catch(Exception e) {}
		}

	}

}
