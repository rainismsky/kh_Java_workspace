package day0516;
public class ArrayCopyEx {
public static void main(String[] args) {
	byte ar1[] = {11,22,33,44,55};
	byte ar2[] = new byte[10]; //10ĭ ¥�� ���� ����
	
	System.arraycopy(ar1,0,ar2,3,5);
	//ar1�迭�� 0������ ar2�迭�� 3�� �ڸ��� 5���� �����͸� ����
	System.out.println("=========���� �迭===========");
	
	for (byte n : ar1)
	
	System.out.print(n+"");
	System.out.println();
	System.out.println("::::::::���纻 �迭---------");
	
	for (byte n: ar2)
		System.out.print(n + "");
	}
}
