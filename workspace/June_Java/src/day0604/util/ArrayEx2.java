package day0604.util;

import java.util.Arrays;

public class ArrayEx2 {
	public static void main(String[] args) {
		String[] ar1 = {"fill()","in","the","Arrays"};
		String[] ar2 = {"fill()","in","","Arrays"};
		
		if(!Arrays.equals(ar1, ar2))
			System.out.println("�� �迭�� �ٸ��ϴ�.");
		System.out.println("--------------------------");
		
		Arrays.fill(ar2, 2,3,"the");
		if(!Arrays.equals(ar1, ar2))
			System.out.println("�� �迭�� �ٸ��ϴ�.");
		else
			System.out.println("�� �迭�� �����ϴ�.");
	}
}
