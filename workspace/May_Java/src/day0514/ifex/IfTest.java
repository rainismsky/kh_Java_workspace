package day0514.ifex;

import java.util.Calendar;

public class IfTest {
	public static void main(String []args){
		//hour엔 현재 시간이 24시간 단위로 들어있다.
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String ampm;
		//if문을 이용해 am.pm에 오전or오후 값을 가지도록 만드세요.
		
		if (hour > 12)
		{ ampm = "오전.am";
		
		}else { ampm = "오후.pm";
		
		System.out.println("지금시간은 "+ hour +"시이고," + ampm + "입니다.");
	}
}
}