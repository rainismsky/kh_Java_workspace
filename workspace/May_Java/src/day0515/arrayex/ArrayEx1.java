package day0515.arrayex;

public class ArrayEx1 {
	public static void main(String[] args) {
		/*char[] ch;
		ch = new char[4];
		
		ch[0] = 'J';
		ch[1] = 'A';
		ch[2] = 'V';
		ch[3] = 'A';
		
		for(int i=0; i<ch.length; i++) {
			System.out.println("ch[" + i + "]:" + ch[i]);
		}*/
		
		int[] i = {1,2,3,4};
		int[] i2 = new int[] {1,2,3,4};
		
		for(int iv: i) {
			System.out.println(iv);
		}
	}
}
