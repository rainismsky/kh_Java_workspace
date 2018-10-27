package day0529.exception;

public class ExceptionEx1 {
	public static void main(String[] args) {
		int[] array = {10,200,30};
		for(int i=0; i<=3; i++)
			try {
				//System.out.println((i+1)+"번째실행");
				System.out.println("array[" + i + "]: " + array[i]);
				//System.out.println((i+1)+"~~~~~");
			}catch(ArrayIndexOutOfBoundsException ae) { 
				System.out.println("예외발생");
				System.out.println(ae.getMessage()); //발생한 예외객체에 메세지 출력
				ae.printStackTrace(); //예외추적메소드
			}finally {
				System.out.println((i+1) + ":::finally:::");
			}
			
		System.out.println("프로그램 끝");
	}
}
