package day0604.collection;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

import static java.lang.System.out;
class CalendarEx1 {

	public static void main(String[] args) {
		StringBuffer sb =new StringBuffer("2018sus��");
		Calendar now = Calendar.getInstance();
		int week_yy = now.get(Calendar.WEEK_OF_YEAR);
		int yy = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH)+1; //1���� 0�� �����.
		int dd = now.get(Calendar.DAY_OF_MONTH);
		sb.append(week_yy);
		sb.append("�֤���");
		sb.append(yy);
		sb.append("��");
		sb.append(mm);
		sb.append("��");
		sb.append(dd);
		sb.append("��");
		out.println(sb.toString());
		
		
	}

}
