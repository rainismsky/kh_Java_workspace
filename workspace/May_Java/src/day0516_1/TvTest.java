package day0516_1;
public class TvTest {
public static void main(String[] args) {
	Tv t; //TvŬ������ ������ ��ü�� �ּҰ�.
	t = new Tv(); 
	
	/*new�� �ϴ� ������ �޸� ������ �Ҵ������ 
	 �� ������ �ν��Ͻ� Ŭ������ �������. 
	new����� Tv Ÿ�� �ڿ� ���ȣ �ϰ� �ݾ���߿����� �ȳ���*/
	
	/*new ::: heap������ �ּ� �Ҵ� 
	���� �����ؼ� Ŭ������ ����� �ν��Ͻ��� ����.*/

	t.color = "red";
	t.ch = 10;
	t.chUp();
	System.out.println("���� ä����" +t.ch+ "�Դϴ�");
}
}
