package day0515.forex;

public class MultiForEx2 {
	public static void main(String[] args) {
		char ch = 65;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(ch++ + "\t");
			}
			System.out.println();
		}
	}
}
