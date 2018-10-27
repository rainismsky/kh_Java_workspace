package day0601;

import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		System.out.println("::::::::Vector생성시:::::::");
		System.out.println("Capacity : " + v.capacity());
		System.out.println("size : " + v.size());
		
		v.add("여진구");
		v.add("수지");
		v.addElement("설현");
		
		System.out.println(":::::::::요소 추가후:::::::::::");
		System.out.println("capacity : " + v.capacity());
		System.out.println("size : " + v.size());
	}
}
