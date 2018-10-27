package day0529.exception;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
		}catch(NumberFormatException ne) { //문자가 들어갔다면 발생하는 예외를catch
			System.out.println("숫자가 아닙니다.");
		}catch(ArithmeticException ae) { //0이 들어갔다면 발생하는 예외를 catch
			System.out.println("0으로 못나눔");
		}
		System.out.println("프로그램 종료!");
	}
}

