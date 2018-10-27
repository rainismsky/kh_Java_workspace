package day0604.collection;

import java.util.Random;
import static java.lang.System.out;


public class RandomEx1 {

	public static void main(String[] args) {
		String[] lesson = {"Java Beg","JSP","XML&Java","Framework"};
		Random r1 = new Random();
		
		int index = r1.nextInt(4);
		
		out.println("선택과목:" + lesson[index]);
		
		}
	}
