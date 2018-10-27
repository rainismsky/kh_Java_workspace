package day0604.collection;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

import static java.lang.System.out;
class CalendarEx1 {

	public static void main(String[] args) {
		StringBuffer sb =new StringBuffer("2018sus중");
		Calendar now = Calendar.getInstance();
		int week_yy = now.get(Calendar.WEEK_OF_YEAR);
		int yy = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH)+1; //1월이 0을 기억해.
		int dd = now.get(Calendar.DAY_OF_MONTH);
		sb.append(week_yy);
		sb.append("주쨰인");
		sb.append(yy);
		sb.append("년");
		sb.append(mm);
		sb.append("월");
		sb.append(dd);
		sb.append("일");
		out.println(sb.toString());
		
		
	}

}
