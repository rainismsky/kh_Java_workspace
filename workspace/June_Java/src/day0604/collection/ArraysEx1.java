package day0604.collection;

import java.util.Arrays;
import static java.lang.System.out;

public class ArraysEx1 {

	public static void main(String[] args) {
		String[] ar = {"fill()","in","the","Arrays"};
		
		Arrays.fill(ar, "SunAe"); //�迭�� ��ҵ��� "SA" ä��
		for(String n : ar)
			out.print(n+",");
		
		out.println("\n----------------------");
		Arrays.fill(ar, 1,3,"��");
		for(String n : ar)
			out.print(n+",");

	}

}
