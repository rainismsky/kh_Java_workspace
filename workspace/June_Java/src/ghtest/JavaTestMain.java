package exam;

import java.util.StringTokenizer;

public class JavaTestMain {

	public static void main(String[] args) {
		String str = "this is my string";
		
		StringTokenizer st = new StringTokenizer(str);
		
		System.out.println(st.countTokens());
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		System.out.println(st.countTokens());
	}

}
