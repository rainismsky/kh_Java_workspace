package day0514.ifex;

public class IfEx4 {
	public static void main(String[] args) {
		String data = args[0]; // �μ��� �ޱ�
		String res;
		if (data.equals("����")) {
			res = "���ִ�.";
		} else if (data.equals("����")) {
			res = "�ÿ��ϴ�.";
		} else if (data.equals("����")) {
			res = "�޴�";
		} else
			res = "��Ÿ";// if end.
		System.out.println(res);
	}

}
