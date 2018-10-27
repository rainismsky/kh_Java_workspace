package day0604.util;

import java.util.Calendar;

public class CalendarEx4 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2018,7,31); //2018년 8월 31일
		
		System.out.println(toString(date));
		System.out.println("= 1일 후  =");
		date.add(Calendar.DATE, 1); 
		System.out.println(toString(date));
		
		System.out.println("= 6달 전 =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("= 31일 후(roll) =");
		date.roll(Calendar.DATE, 31); //다른 field 수정못함 ->31더해서 그대로 3월1일
		System.out.println(toString(date));
		
		System.out.println("= 31일 후 (add) =");
		date.add(Calendar.DATE, 31); //다른field 수정가능
		System.out.println(toString(date));
		
		date.set(2018, 0, 31);
		date.roll(Calendar.MONTH, 1);
		System.out.println(toString(date));
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" 
				+ (date.get(Calendar.MONTH) + 1) + "월 " 
				+ date.get(Calendar.DATE) + "일";
	}
}
