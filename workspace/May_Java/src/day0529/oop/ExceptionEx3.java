package day0529.oop;

public class ExceptionEx3 {

	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
			
		}catch(NumberFormatException ne) {
			System.out.println("���� �Ƴ�");

		}catch(ArithmeticException ae) {
			System.out.println("0���� ������ ����?");
		}
		catch(Exception e) {
			System.out.print("���ܹ߻�");
		}
		
		System.out.println("���α׷� ����!");
		
		}
	}
