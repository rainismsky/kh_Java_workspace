package day0601;
import java.util.*;

public class TreeSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();

		for (int i = 0; set.size() < 6; i++) { //�÷��ǿ� �����ϰ��ִ� �������� ������ 6����������������
			int num = (int) (Math.random() * 45) + 1; //1���� 45������ ������ ������ �����Լ� �߻�
			//������ ���ڰ� 6���� set�� �� 
			set.add(new Integer(num));
		}

		System.out.println(set);
	}
}
