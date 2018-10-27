package day0607.thread;

public class SingleThreadEx extends Thread {
	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx("첫번째");
		//st.run(); //스레드 이름이 첫번째가 아니고 main이라고 출력됨
		st.start();
	/*	SingleThreadEx st1 = new SingleThreadEx("두번째");
		st1.start();
		SingleThreadEx st2 = new SingleThreadEx("세번째");
		st2.start(); 멀티스레드 지원*/ 
		//뭐가먼저 실행될 지 모르기 때문에 결과는 매번 달라진다
	}
	
	private int[] temp;
	
	public SingleThreadEx(String threadname) {
		super(threadname);
		temp = new int[10];
		for(int start=0; start<temp.length;start++) {
			temp[start] = start;
		}
	}
	
	public void run() {
		for(int start : temp) {
			try {
				sleep(1000); //1초
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		
		System.out.printf("스레드 이름 : %s,",currentThread().getName()); //%s문자열, currentThread() 현재스레드의 getName..
		System.out.printf("temp value : %d %n", start); //%d정수 , %n줄바꿈
		}
	}
	
}
