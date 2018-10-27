package day0607.thread;

public class CalcThread extends Thread {
	public CalcThread(String name) {
		setName(name);
	}
	public void run() {
	for(int i=0; i<200000000; i++) { // i가 0이고 i이가 2억번 돌때까지 1씩 증가시켜라
		
	}
	System.out.println(getName()); //현 쓰레드 name값 출력
	
	}
	
}
