package day0604.collection;

import java.util.Arrays;
import static java.lang.System.out;

public class ArraysEx2 {

	public static void main(String[] args) {
		String[] ar1 = {"fill()","in","the","Arrays"};
		String[] ar2 = {"fill()","in","the","Arrays"};
		
		if(!Arrays.equals(ar1, ar2))
			out.println("�� �迭�� �ٸ�.");
		out.println("--------------------------------");
		
		Arrays.fill(ar2,2,3,"the");
		if(!Arrays.equals(ar1,ar2))
			out.println("�� �迭�� �ٸ�");
		
		else 
			out.println("�� �迭�� ����");
	}

}
