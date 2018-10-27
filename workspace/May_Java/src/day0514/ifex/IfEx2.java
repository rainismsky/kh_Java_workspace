package day0514.ifex;

public class IfEx2 {
	public static void main(String[] args) {

		int su1 = Integer.parseInt(args[0]);
		String res = "";
		if (su1 >= 40) {
			res = "고급";
		} else if (su1 >= 10) {
			res = "중급";

		} else
			res = "초급";

		System.out.println(res);
	}
}
