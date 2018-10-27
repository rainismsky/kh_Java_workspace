package day0531.lang;

public class StringEx3 {
	public static void main(String[] args) {
		String s1 = "AAA";
		String s2 = new String("AAA");
		
		if(s1 == s2) {
			System.out.println("s1==s2 ? true");
		}else {
			System.out.println("s1==s2 ? true");
		}
		s2 = s2.intern(); //생성자 방식으로 생성된 객체를 constance pool에 등록
		System.out.println("s2에 intern()을 호출한 후");
		
		if(s1 == s2) {
			System.out.println("s1==s2 ? true");
		}else {
			System.out.println("s1==s2 ? true");
		}
		

	}

}
