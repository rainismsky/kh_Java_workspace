package day0604.collection;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormatEx1 {
public static void main(String[] args) {
	Date today = new Date();
	
	SimpleDateFormat sdf1,sdf2,sdf3,sdf4;
	SimpleDateFormat sdf5,sdf6,sdf7,sdf8,sdf9;
	
	sdf1 = new SimpleDateFormat("YYYY-MM-DD");
	sdf2 = new SimpleDateFormat("YY년 MMM DD일 E 요일");
	sdf3 = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
	sdf4 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss a");
	
	sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날");
	sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날");
	sdf7 = new SimpleDateFormat("오늘은 올 해의 W번째 주");
	sdf8 = new SimpleDateFormat("오늘은 이 달의 w번째 주");
	sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E 요일");
	
	System.out.println(sdf1.format(today));
	System.out.println(sdf2.format(today));
	System.out.println(sdf3.format(today));
	System.out.println(sdf4.format(today));
	System.out.println();
	System.out.println(sdf5.format(today));
	System.out.println(sdf6.format(today));
	System.out.println(sdf7.format(today));
	System.out.println(sdf8.format(today));
	System.out.println(sdf9.format(today));
	
	
	

	}

}
