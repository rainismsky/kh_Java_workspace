package day0514.ifex;

public class IfEx4 {
	public static void main(String[] args) {
		String data = args[0]; // 인수값 받기
		String res;
		if (data.equals("포도")) {
			res = "맛있다.";
		} else if (data.equals("수박")) {
			res = "시원하다.";
		} else if (data.equals("딸기")) {
			res = "달다";
		} else
			res = "기타";// if end.
		System.out.println(res);
	}

}
