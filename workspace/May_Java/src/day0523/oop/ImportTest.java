package day0523.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
//여러개 한번에 import 할시 컨트롤 +쉬프트+알파벳 o 누르셈

public class ImportTest {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println("현재시간:: " +d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss z a"); 
		//여기서 a의 의미는 am./pm.이다
		//간단히 날짜를 포멧해주는 클래스
		
		System.out.println(sdf.format(d));
	}
}
