package day0530.oop;

public class StringEx1 {
public static void main(String[] args) {
	String str1 = "abc";
	String str2 = "abc";
	
	System.out.println("String str1 = \"abc\";");
	System.out.println("String str2 = \"abc\";");
	
	if(str1 == str2) {//t
		System.out.println("str1 == str2 ? true");
	}else {
		System.out.println("Str1 == str2 ? false");
	}
	if(str1.equals(str2)) {//t
		System.out.println("str1.equals(str2)?true");
	}else {
		System.out.println("str1.equals(str2)?flase");
	}
	System.out.println();
	
	String str3 = new String("\"abc\"");
	String str4 = new String("\"abc\"");
	
	System.out.println("String str3 = new String(\"abc\");");
	System.out.println("String str4 = new String(\"abc\");");
	
	if(str3 == str4) {//f
		System.out.println("str3 == str4 ? true");
	}else {
		System.out.println("str3 == str4 ? true");	
		
	} System.out.println("str3 == str4 ? true");

	}
}
