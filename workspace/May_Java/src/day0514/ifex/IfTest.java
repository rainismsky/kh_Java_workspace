package day0514.ifex;

import java.util.Calendar;

public class IfTest {
	public static void main(String []args){
		//hour�� ���� �ð��� 24�ð� ������ ����ִ�.
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String ampm;
		//if���� �̿��� am.pm�� ����or���� ���� �������� ���弼��.
		
		if (hour > 12)
		{ ampm = "����.am";
		
		}else { ampm = "����.pm";
		
		System.out.println("���ݽð��� "+ hour +"���̰�," + ampm + "�Դϴ�.");
	}
}
}