package day0529.exception;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
		}catch(NumberFormatException ne) { //���ڰ� ���ٸ� �߻��ϴ� ���ܸ�catch
			System.out.println("���ڰ� �ƴմϴ�.");
		}catch(ArithmeticException ae) { //0�� ���ٸ� �߻��ϴ� ���ܸ� catch
			System.out.println("0���� ������");
		}
		System.out.println("���α׷� ����!");
	}
}

