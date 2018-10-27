package exam;

import java.util.StringTokenizer;

public class JavaTestMain1 {

	public static void main(String[] args) {
		String str = "this%%is%%my%%String";
		
		StringTokenizer st = new StringTokenizer(str,"%%");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

}
