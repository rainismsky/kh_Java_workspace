package day0511;

public class StringEx {
	// java.lang.String 클래스 - 문자열 표현
	// String 클래스명을 데이터 타입으로 삼는 (참조형 데이터 타입)
	// "를 이용해 문자열 표현
	// "" :: 빈문자열 "" ::공백 => 다 문자열로 인식함.
	
	private static final char[] Str2 = null;

	public static void main(String[] args) {
		String s = "문자열 저장";
		System.out.println(s);
		
		String s1 = " ";
		String s2 = "";
		
		System.out.println('A'+1); // 66
		// + 연산은 String에 우선권을 가짐. 다른 데이터도 String으로 변경
		// abc + 123 이어쓰기 가능. 사용 데이터 Type은 String!
		System.out.println("A"+1); // A1 <= (String Type 대표적인 예)		

		// String <= int :: int데이터+""
		
		String str = 7+"";
		String str1 = ""+7;
		String str2 = " "+7;
		
		String str3 = "" + 7 + 7; //77
		String str4 = 7 + 7 + "";
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
	
	}
}
