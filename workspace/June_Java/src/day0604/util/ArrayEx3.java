package day0604.util;

import java.util.Arrays;

public class ArrayEx3 {
	public static void main(String[] args) {
		int[] ar1 = {6,3,7,2,1};
		
		Arrays.sort(ar1);
		for(int n : ar1)
			System.out.println(n+",");
	}
}
