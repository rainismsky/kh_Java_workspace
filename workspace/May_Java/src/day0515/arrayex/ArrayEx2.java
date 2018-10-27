package day0515.arrayex;

public class ArrayEx2 {
	public static void main(String[] args) {
		char[] c = new char[26];
		char a = 65;
		for(int i=0; i<c.length; i++) {
			c[i] = a++;
			//System.out.println(c[i]);
		}
		System.out.println(c);//문자열
		
		int[] i = {1,2,3,4};
		System.out.println(i);//배열의주소값
	}
}
