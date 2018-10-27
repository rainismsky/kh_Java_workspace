package day0601;

import java.util.*;

public class HashSetEx1 {
	public static void main(String[] args) {
		String[] str = {"Java", "Beans","Java","XML"};
		
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		for(String n : str) {
			if(!hs1.add(n));
				hs2.add(n);
		}
		System.out.println("hs1 : " + hs1);
		hs1.removeAll(hs2);
		System.out.println("hs1: " + hs1);
		System.out.println("hs2 : " + hs2);
		
		
		/*Object[] objArr = {"1",new Integer(1),"2","2","3","3","4","4","4"};
		Set<Object> set = new HashSet<Object>();
		
			for(int i=0; i<objArr.length; i++) {
				set.add(objArr[i]);// HashSet에 objArr의 요소들을 저장한다.
			}
			System.out.println(set);// HashSet에 저장된 요소들을 출력한다.
*/	}
}
