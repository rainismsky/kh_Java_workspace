package day0516;

public class ObjArrayEx2 {
public static void main(String[] args) {
	//argument(�μ�)�� ������ length�� 0�� �迭���� 
	String[] arr;
	
	if(args.length > 0) { //args length(�迭�Ǳ��̴� 4)
		arr = args; // args�� ���� �ִ� ���� arr���� �ֶ�� ���
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"]:"+arr[i]);
		}
	}else {
		System.out.println("args�� ������ ����.");
	}
}

}
