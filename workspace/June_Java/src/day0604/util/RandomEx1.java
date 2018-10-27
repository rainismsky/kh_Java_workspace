package day0604.util;

import java.util.Random;

public class RandomEx1 {
	public static void main(String[] args) {
		String[] lesson = {"Java Beg","DB","JSP","Framework"};
		Random r1 = new Random();
		
		int index=r1.nextInt(4);
		
		System.out.println("선택과목 : " + lesson[index]);
	}
}

