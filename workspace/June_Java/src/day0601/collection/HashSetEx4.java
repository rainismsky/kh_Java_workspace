package day0601.collection;

import java.util.*;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class HashSetEx4 { //���� �����Բ��� Ŭ������ ���θ޼ҵ�� ���� ������ ���� �ؼ� ����ϴ°� ȿ�����̶�� �����ϼ̴�.
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));//hashcode
		set.add(new Person2("David",10)); //hashcode(), equals() 
		
		System.out.println(set);
		
	}
	

}
