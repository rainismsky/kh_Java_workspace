package day0514.ifex;

import java.util.Scanner;

public class IfEx3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num;

		System.out.println("������ �Է��϶�!");

		num = input.nextInt();
		if (num % 2 == 0) {
			System.out.println(num + "�� ¦����.");

		}
		input.close();

	}

}
