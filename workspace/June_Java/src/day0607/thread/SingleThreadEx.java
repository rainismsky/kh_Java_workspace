package day0607.thread;

public class SingleThreadEx extends Thread {
	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx("ù��°");
		//st.run(); //������ �̸��� ù��°�� �ƴϰ� main�̶�� ��µ�
		st.start();
	/*	SingleThreadEx st1 = new SingleThreadEx("�ι�°");
		st1.start();
		SingleThreadEx st2 = new SingleThreadEx("����°");
		st2.start(); ��Ƽ������ ����*/ 
		//�������� ����� �� �𸣱� ������ ����� �Ź� �޶�����
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
				sleep(1000); //1��
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		
		System.out.printf("������ �̸� : %s,",currentThread().getName()); //%s���ڿ�, currentThread() ���罺������ getName..
		System.out.printf("temp value : %d %n", start); //%d���� , %n�ٹٲ�
		}
	}
	
}
