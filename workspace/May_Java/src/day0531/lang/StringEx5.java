package day0531.lang;

public class StringEx5 {

	
		static String s; //null
		static String s2 = ""; 	//빈문자열 조기화 
						//String타입은 항상 빈문자열로 초기화 시켜서 쓰는 습관을 들이자 !
	
		public static void main(String args[]) {
			for(int i = 1;i <10; i++) {
				s += i; //s=s+i;
				s2 += i;
			}
			System.out.println(s);	//null123456789
			System.out.println(s2);
		}

}
