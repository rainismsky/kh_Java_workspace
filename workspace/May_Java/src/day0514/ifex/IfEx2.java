package day0514.ifex;

public class IfEx2 {
	public static void main(String[] args) {

		int su1 = Integer.parseInt(args[0]);
		String res = "";
		if (su1 >= 40) {
			res = "���";
		} else if (su1 >= 10) {
			res = "�߱�";

		} else
			res = "�ʱ�";

		System.out.println(res);
	}
}
