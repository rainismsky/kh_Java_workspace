package day0604.collection;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormatEx1 {
public static void main(String[] args) {
	Date today = new Date();
	
	SimpleDateFormat sdf1,sdf2,sdf3,sdf4;
	SimpleDateFormat sdf5,sdf6,sdf7,sdf8,sdf9;
	
	sdf1 = new SimpleDateFormat("YYYY-MM-DD");
	sdf2 = new SimpleDateFormat("YY�� MMM DD�� E ����");
	sdf3 = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
	sdf4 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss a");
	
	sdf5 = new SimpleDateFormat("������ �� ���� D��° ��");
	sdf6 = new SimpleDateFormat("������ �� ���� d��° ��");
	sdf7 = new SimpleDateFormat("������ �� ���� W��° ��");
	sdf8 = new SimpleDateFormat("������ �� ���� w��° ��");
	sdf9 = new SimpleDateFormat("������ �� ���� F��° E ����");
	
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
