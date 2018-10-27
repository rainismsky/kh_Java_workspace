package exam;

import java.util.StringTokenizer;

public class exam1 {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("will you marry me?");
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());

	}

}
