package day0531.lang;

public class StringEx2 {

	public static void main(String[] args) {
		String s1 = "AAA";
		String s2 = "AAA";
		String s3 = "AAA";
		String s4 = "BBB";
		
		System.out.println(s1.hashCode()); 
		System.out.println(System.identityHashCode(s1));
		
		System.out.println(s2.hashCode());
		System.out.println(System.identityHashCode(s2));
		
		System.out.println(s3.hashCode());
		System.out.println(System.identityHashCode(s3));
		
		System.out.println(s4.hashCode());
		System.out.println(System.identityHashCode(s4));
	}

}
