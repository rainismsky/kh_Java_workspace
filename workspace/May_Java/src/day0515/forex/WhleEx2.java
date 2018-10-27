package day0515.forex;

public class WhleEx2 {
	public static void main(String[] args) {
		int i=0;
		int sum=0;
		int num = Integer.parseInt(args[0]);
		while(i<=num) {
			sum+=i;
			i++;
		}System.out.println(sum);
	}
}
