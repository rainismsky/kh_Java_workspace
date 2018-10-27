package day0531.lang;

public class StringBufferEx1 {
public static void main(String[] args) {
	StringBuffer sb= new StringBuffer("abc");
	StringBuffer sb2= new StringBuffer("abc");

	if(sb == sb2) {
		System.out.println("sb == sb2 ? true");
	}else {
		System.out.println("sb == sb2 ? false");
	}
	if(sb.equals(sb2)) {
		System.out.println("sb == sb2 ? true");
	}else {
		System.out.println("sb == sb2 ? false");
	}
	//StringBuffer의 내용을 String로 변환함!
	
	String s = sb.toString(); //String s = new String(sb);와 같다.
	String s2 = sb2.toString();
	}

}
