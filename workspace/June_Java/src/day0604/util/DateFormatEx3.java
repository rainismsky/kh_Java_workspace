package day0604.util;
import java.util.*;
import java.text.*;

public class DateFormatEx3 {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

		try {
			Date d = df.parse("2018년 6월 4일"); //parse는 String을 받아와서 date객체로 바꿔줌.
			//예외가  발생할 수 있어서 throw처리해놓음
			System.out.println(df2.format(d));
		} catch (Exception e) {
		}
		}
	
}
