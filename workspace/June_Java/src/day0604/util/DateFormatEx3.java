package day0604.util;
import java.util.*;
import java.text.*;

public class DateFormatEx3 {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy�� MM�� dd��");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

		try {
			Date d = df.parse("2018�� 6�� 4��"); //parse�� String�� �޾ƿͼ� date��ü�� �ٲ���.
			//���ܰ�  �߻��� �� �־ throwó���س���
			System.out.println(df2.format(d));
		} catch (Exception e) {
		}
		}
	
}
