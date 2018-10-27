package day0604.util;

import java.util.*;
import java.text.*;

public class DateFormatEx4 {
	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd"; 
		DateFormat df = new SimpleDateFormat(pattern);
		
		Scanner s = new Scanner(System.in); //�ܼ�â�� �Է��� ������ �о���� scanner 

		Date inDate = null; //dateŸ���� ���� ����

		System.out.println("��¥�� " + pattern + "�� ���·� �Է����ּ���.(�Է¿�:2007/05/11)");

		while(s.hasNextLine()) {
			try {
				inDate = df.parse(s.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("��¥�� " + pattern + "�� ���·� �ٽ� �Է����ּ���.(�Է¿�:2007/05/11)");
			}
		} // while

		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
        long day = (cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000*24);
		
		System.out.println("�Է��Ͻ� ��¥�� ����� "+ Math.abs(day) +"�� ���̰� �ֽ��ϴ�.");
	} // main
}
