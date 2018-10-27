package day0604.util;

import java.util.Calendar;

public class CalendarEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("2018년중");
		Calendar now = Calendar.getInstance();
		int week_yy = now.get(Calendar.WEEK_OF_YEAR);
		int yy = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH)+1;
		int dd = now.get(Calendar.DAY_OF_MONTH);
		sb.append(week_yy);
		sb.append("주째인");
		sb.append(yy);
		sb.append("년");
		sb.append(mm);
		sb.append("월");
		sb.append(dd);
		sb.append("일");
		
		System.out.println(sb.toString());
		
	}
}
