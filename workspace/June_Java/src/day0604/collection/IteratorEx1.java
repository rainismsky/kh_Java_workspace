package day0604.collection;

//Iterator = 컬렉션에 저장된 객체를 읽어오는 방법을 표준화한 인터페이스. (신.ver)
//Enumeration (구.ver)
//위 두가지는 객체를 만들게 되면 전체다 뽑아와야하며 조금씩뽑아오는건 안된다.

import java.util.*;
public class IteratorEx1 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,5);
		
		v.add("a");
		v.add("b");
		v.add("c");
		System.out.println("벡터크기: " + v.size());
		
		Iterator<String> it = v.iterator(); //Iterator얻기
		while(it.hasNext()) {
		System.out.println(it.next());
					
		//it.remove()l //원본 컬렉션에 요소 삭제
		}
		it.remove();
		System.out.println("벡터 크기:"+v.size());
		System.out.println(v);
	}
}
