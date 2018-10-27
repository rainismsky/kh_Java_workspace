package day0607.thread;

public class SynchronizedMethodEx implements Runnable{
	@Override
	public void run() {
		kitchen();
		bedroom();
	}
	
	public synchronized void kitchen() { //tom�� �������� ����ȭ �ɷ��� �������� jerry�� ����
		System.out.println(Thread.currentThread().getName() + " is in kitchen");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
		}
		System.out.println(Thread.currentThread().getName() + " is leaving kitchen");
	}
	
	public synchronized void bedroom() {
		System.out.println(Thread.currentThread().getName() + " is in bedroom");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		System.out.println(Thread.currentThread().getName() + " is leaving bedroom");
	}
	
	public static void main(String[] args){
		SynchronizedMethodEx sm = new SynchronizedMethodEx();
		
		Thread t = new Thread(sm,"Tom");
		Thread t1 = new Thread(sm,"Jerry");
		t.start();
		t1.start();
	}
	

}
