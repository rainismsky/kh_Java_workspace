package day0515.arrayex;

import java.util.Arrays;

public class ArrayEx3 {
	public static void main(String[] args) {
		int[] ball = new int[45]; //45길이의 배열 ball 선언

		for(int i=0; i<ball.length; i++) //i를 0부터 배열ball길이(45)까지 1씩 더하며 반복
			ball[i] = i+1; //ball배열 0칸 부터 44칸까지 1~45까지 차례로 집어넣음
		int temp=0; //숫자교환 시 임시저장용 변수
		int j=0; //랜덤값 저장할 변수
		
		for(int i=0; i<100; i++) { //i를 0부터 99까지 1씩 더하며 반복 (잘 섞이도록 충분히 크게 지정)
			j = (int)(Math.random()*45); //j에  0부터 44까지의 숫자 중에서 랜덤하게 하나 저장 (예:5)
			temp = ball[0]; //temp에 ball[0]번째 값을 저장 ->1
			ball[0] = ball[j]; //ball[0]번째 칸에 ball[j]칸의 값을 저장 (예: ball[0] ->6);
			ball[j] = temp; //ball[j]번째 칸에 temp값을 저장 (예: ball[5]->1); 
			//숫자 교환을 100번 반복해서 ball에 들어있는 1~45의 수를 랜덤하게 저장함
		}
		for(int i=0; i<6; i++) 
			System.out.print(ball[i]+" "); //앞에서부터 6개의 수를 차례로 출력 
		
		int[] rotto = new int[6];
		for(int i=0; i<6; i++)
			rotto[i] = ball[i];
		
		Arrays.sort(rotto);
		
		for(int i : rotto) {
			System.out.print(i+"\t");
		}
	}
}
