package day0529.oop;

public class ExceptionEx3 {

	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
			
		}catch(NumberFormatException ne) {
			System.out.println("숫자 아냐");

		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌순 없냐?");
		}
		catch(Exception e) {
			System.out.print("예외발생");
		}
		
		System.out.println("프로그램 종료!");
		
		}
	}
