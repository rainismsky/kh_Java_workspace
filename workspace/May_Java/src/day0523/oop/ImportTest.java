package day0523.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
//������ �ѹ��� import �ҽ� ��Ʈ�� +����Ʈ+���ĺ� o ������

public class ImportTest {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println("����ð�:: " +d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss z a"); 
		//���⼭ a�� �ǹ̴� am./pm.�̴�
		//������ ��¥�� �������ִ� Ŭ����
		
		System.out.println(sdf.format(d));
	}
}
