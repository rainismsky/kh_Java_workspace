package day0514.ifex;

public class IfEx1 {
	public static void main(String[] args) {

		// if(���ǽ� /���� �׽���){���ǽ� ����� true�϶� ������ ����}
		// }else {���ǽ� ����� false�� �� ������ ����}
		// ���๮�� 1���϶� {} ���� ����
		// �μ�,����,parameter,argument :: �����ϴ� ��
		// ����� �Է��� ���� ���� �޾� ���.String�����ʹ�.

		int su1 = Integer.parseInt(args[0]);
		String str = ""; // String�� �׻� ���ڿ�("")�� �ʱ�ȭ ���ѳ��� ����Ѵ�.

		if (su1 >= 50) {
			str = "50�̻�";
		} else {
			str = "50�̸�";

			/*
			 * false���� ��� str ���� �޾ƿü��� ���� �׷��� str�� �׻� ���ڿ�""���� �ʱ�ȭ ���ѳ��� ��� ������ ����
			 */

		}
		System.out.println(str);

	}

}
