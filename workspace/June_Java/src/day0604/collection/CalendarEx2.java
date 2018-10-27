package day0604.collection;

import java.util.*;

public class CalendarEx2 {
public static void main(String[] args) {
	//������ 1���� �����ϱ� ������,DAY_OF_WEEK[0]�� ����״�.
	
	final String[] DAY_OF_WEEK = {"","��","��","ȭ","��","��","��","��"};
	
	Calendar date1 = Calendar.getInstance();
	Calendar date2 = Calendar.getInstance();
	
	date1.set(1991,10,21);
	System.out.println("date1��" + toString(date1)+DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"������Go,");
	System.out.println("����(date2)��"+ toString(date2)+DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"�����̴�.");

	long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
	System.out.println("�׳�(date1)���� ����(date2)����" + difference + "�ʰ� �������ϴ�.");
	System.out.println("��(day)�� ����ϸ� " + difference / (24*60*60) + "���̿�."); //1��
	
}

public static String toString(Calendar date) {
	return date.get(Calendar.YEAR) + "��" + (date.get(Calendar.MONTH)+1) + "��" + date.get(Calendar.DATE)+"��";
	
	
	}

}
