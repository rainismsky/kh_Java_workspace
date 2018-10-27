package day0515.forex;

public class MultForEx {
public static void main(String[] args) {
	for (int i = 0; i < 3; i++) {
		for(int j =0; j < 3; j++) { //false 값이 나왔을때 안에 있는 for문에 j는 사라져야함.
			System.out.println(i+" "+j);
		}
	}
}
}

