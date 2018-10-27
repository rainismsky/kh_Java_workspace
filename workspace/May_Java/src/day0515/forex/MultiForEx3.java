package day0515.forex;

public class MultiForEx3 {
	public static void main(String[] args) {
		for(int i=9; i>1; i--) {
			for(int j=2; j<10; j++) {
				System.out.print(j + "X" + i + "=" + j*i + "\t");
			}
			System.out.println();
		}
	}
}
