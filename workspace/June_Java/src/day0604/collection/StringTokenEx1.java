package day0604.collection;

import java.util.StringTokenizer;

class StringTokenEx1{
	StringTokenizer st;
	public StringTokenEx1(String str) {
		System.out.println("str: + str");
		st = new StringTokenizer(str);
	}
	public StringTokenEx1(String str,String delim) {
		System.out.println("str:" + str);
		st=new StringTokenizer(str,delim);
	}
	
	public void print() {
		System.out.println("Token count:" + st.countTokens());
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("-----------------");

		}
	}
}