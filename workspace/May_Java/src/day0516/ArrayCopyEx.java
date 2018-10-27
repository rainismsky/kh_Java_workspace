package day0516;
public class ArrayCopyEx {
public static void main(String[] args) {
	byte ar1[] = {11,22,33,44,55};
	byte ar2[] = new byte[10]; //10칸 짜리 공간 생성
	
	System.arraycopy(ar1,0,ar2,3,5);
	//ar1배열의 0번부터 ar2배열의 3번 자리에 5개의 데이터를 복사
	System.out.println("=========원본 배열===========");
	
	for (byte n : ar1)
	
	System.out.print(n+"");
	System.out.println();
	System.out.println("::::::::복사본 배열---------");
	
	for (byte n: ar2)
		System.out.print(n + "");
	}
}
