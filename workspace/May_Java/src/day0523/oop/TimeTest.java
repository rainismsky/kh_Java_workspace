/*package day0523.oop;

public class TimeTest {
public static void main(String[] args) {
		Time t = new Time(12,35,30);
		System.out.println(t);
		//t.hour = 13;
		t.setHour(t.getHour()+1); //���� �ð����� 1�ð� �ķ� ������
		System.out.println(t);
	}
}

class Time {
	private int hour;
	private int minute;
	private int second;
	
	Time(int hour, int minute , int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

public int getHour() { return hour;}
public void setHour(int hour) {
	if(minute < 0|| hour>23) return;
	this.hour = hour;
}

public int getMinute(){ return hour;}
public void setMinute(int minute) {
	if(minute < 0|| hour>59) return;
	this.minute = minute;
}
public int getSecond() { return second; }
public void setSecond(int second) {
	if(minute < 0|| hour>59) return;
	this.second = second;
}

@Override
public String toString() {
	return hour + ":" + minute + ":" + second;
}
}*/