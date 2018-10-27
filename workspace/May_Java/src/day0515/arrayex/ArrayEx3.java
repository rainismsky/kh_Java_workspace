package day0515.arrayex;

import java.util.Arrays;

public class ArrayEx3 {
	public static void main(String[] args) {
		int[] ball = new int[45]; //45������ �迭 ball ����

		for(int i=0; i<ball.length; i++) //i�� 0���� �迭ball����(45)���� 1�� ���ϸ� �ݺ�
			ball[i] = i+1; //ball�迭 0ĭ ���� 44ĭ���� 1~45���� ���ʷ� �������
		int temp=0; //���ڱ�ȯ �� �ӽ������ ����
		int j=0; //������ ������ ����
		
		for(int i=0; i<100; i++) { //i�� 0���� 99���� 1�� ���ϸ� �ݺ� (�� ���̵��� ����� ũ�� ����)
			j = (int)(Math.random()*45); //j��  0���� 44������ ���� �߿��� �����ϰ� �ϳ� ���� (��:5)
			temp = ball[0]; //temp�� ball[0]��° ���� ���� ->1
			ball[0] = ball[j]; //ball[0]��° ĭ�� ball[j]ĭ�� ���� ���� (��: ball[0] ->6);
			ball[j] = temp; //ball[j]��° ĭ�� temp���� ���� (��: ball[5]->1); 
			//���� ��ȯ�� 100�� �ݺ��ؼ� ball�� ����ִ� 1~45�� ���� �����ϰ� ������
		}
		for(int i=0; i<6; i++) 
			System.out.print(ball[i]+" "); //�տ������� 6���� ���� ���ʷ� ��� 
		
		int[] rotto = new int[6];
		for(int i=0; i<6; i++)
			rotto[i] = ball[i];
		
		Arrays.sort(rotto);
		
		for(int i : rotto) {
			System.out.print(i+"\t");
		}
	}
}
