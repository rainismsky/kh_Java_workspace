package day0604.util;

import java.util.StringTokenizer;

public class StringTokenEx1 {
	StringTokenizer st;
	
	public StringTokenEx1(String str) {
		System.out.println("str : " + str);
		st = new StringTokenizer(str);
	}
	
	public StringTokenEx1(String str,String delim) {
		System.out.println("str : " + str);
		st = new StringTokenizer(str,delim,true);
	}
	
	public void print() {
		System.out.println("Token count : " + st.countTokens());
		while(st.hasMoreTokens()) { //뒤에 토큰이 더 있으면
			String token = st.nextToken(); //token에 다음 토큰 저장
			System.out.println(token); //저장한 다음토큰 출력
		}
		System.out.println("-------------------------");
	}
	
	
	public static void main(String[] args) {
		StringTokenEx1 st1 = new StringTokenEx1("Happy day");
		st1.print();
		
		StringTokenEx1 st2 = new StringTokenEx1("2005/08/15","/");
		st2.print();
	}
}
