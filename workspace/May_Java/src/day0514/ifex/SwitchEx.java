package day0514.ifex;

public class SwitchEx {
	public static void main(String[] args) {
		// 월을 입력 -> 해달 월이 몇일까지 있는지 출력.
		int month = Integer.parseInt(args[0]);
		String res = "";

		switch (month) {
		case 1:
		case 3:
		case 5:
			res = "31";
			break;
		case 7:
		case 8:
		case 10:
		case 12:
			res = "31";
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			res = "30";
			break;
		case 2:
			res = "28";
			break;
		default:
			res = "숫자 다시 입력";

		}// switch end.
		System.out.println(month + "월은" + res + "일 입니다.");
	}
}