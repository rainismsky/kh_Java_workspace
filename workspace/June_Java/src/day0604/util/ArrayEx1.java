package day0604.util;

import java.util.Arrays;

public class ArrayEx1 {
	public static void main(String[] args) {
		String[] ar = {"fill()","in","the","Arrays"};
		
		Arrays.fill(ar, "SunAe");
		for(String n : ar)
			System.out.print(n+",");
		
		System.out.println("\n------------------------------");
		Arrays.fill(ar, 1,3,"¢¾");
		for(String n:ar)
			System.out.print(n+",");
	}
}
