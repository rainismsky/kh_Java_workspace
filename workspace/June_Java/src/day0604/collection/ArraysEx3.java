package day0604.collection;

import java.util.Arrays;
import static java.lang.System.out;

public class ArraysEx3 {
	public static void main(String[] args) {
		int[] ar1 = {6,3,7,2,1};
		
		Arrays.sort(ar1);
		for(int n:ar1)
			out.print(n+",");
	
	
	}
}
