package day0516.arrayex;

public class ObjArrayEx2 {
	public static void main(String[] args) {
		//argument�� ������ length�� 0�� �迭�� ������
		String[] arr;
		if(args.length > 0) {
			arr = args; //�ּҰ��� �Ѱ��� (�Ȱ��� ������ ���)
			for(int i=0; i<arr.length; i++) {
				System.out.println("arr[" + i + "] : " + arr[i]);
			}
		}else {
			System.out.println("args�� ������ �����ϴ�.");
		}
	}
}
