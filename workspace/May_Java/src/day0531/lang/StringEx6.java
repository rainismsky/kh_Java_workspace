package day0531.lang;

public class StringEx6 {
	public static void main(String[] args) {
		char[] cArr = new char[0]; //char[] cArr ={};¿Í°°´Ù
		String s = new String(cArr); //
		
		System.out.println("cArr.length=" + cArr.length);
		System.out.println("@@@" + s + "@@@");
	}
}
