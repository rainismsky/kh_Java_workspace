package day0529.oop;

public class ExceptionEx1 {

	public static void main(String[] args) {
		int[] array = {10,200,30};
		for(int i = 0; i <=3; i++)
		try {	
			System.out.println((i+1)+"��° ����");
			System.out.println("array["+i+"]" + array[i]);
			System.out.println((i+1)+"~~~~");
		
		}catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("���ܹ߻�");
			System.out.println(ae.getMessage());
		}
			System.out.println("program end!!!!!!!!!!!!!!!!!!");
}
}