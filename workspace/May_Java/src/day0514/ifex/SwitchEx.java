package day0514.ifex;

public class SwitchEx {
	public static void main(String[] args) {
		// ���� �Է� -> �ش� ���� ���ϱ��� �ִ��� ���.
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
			res = "���� �ٽ� �Է�";

		}// switch end.
		System.out.println(month + "����" + res + "�� �Դϴ�.");
	}
}