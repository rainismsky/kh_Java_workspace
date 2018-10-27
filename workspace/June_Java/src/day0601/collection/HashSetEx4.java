package day0601.collection;

import java.util.*;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class HashSetEx4 { //명강좌 선생님께서 클래스와 메인메소드는 파일 생성을 따로 해서 사용하는게 효율적이라고 말씀하셨다.
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));//hashcode
		set.add(new Person2("David",10)); //hashcode(), equals() 
		
		System.out.println(set);
		
	}
	

}
