package day0604.collection;

import java.util.*;

public class CalendarEx4 {
	public static void main(String args[]) {
		Calendar date = Calendar.getInstance();
		date.set(2018,7,31); //2018�� 8�� 31��
		
		System.out.println(toString (date));
		System.out.println("= 1�� �� =");
		date.add(Calendar.DATE,1);
		System.out.println(toString(date));
		
		
		System.out.println("= 6�� �� =");
		date.add(Calendar.MONTH,-6);
		System.out.println(toString(date));
		
		System.out.println("= 31�� �� (roll) =");
		date.roll(Calendar.DATE,31);
		System.out.println(toString(date));
		
		date.set(2018, 0, 31);
		date.add(Calendar.DATE,1);
		System.out.println(toString(date));
		
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "��" + (date.get(Calendar.MONTH)+1)+"��" + date.get(Calendar.DATE)+ "��";
	}
}
