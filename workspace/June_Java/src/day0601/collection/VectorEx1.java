package day0601.collection;

import java.util.Vector;

class VectorEx1 {

	public static void main(String[] args) {

		Vector<String> v = new Vector<String>();

		System.out.println("::Vector생성시::");
		System.out.println("capacity : " + v.capacity()); // 
		System.out.println("size : " + v.size()); // 

		// 자원추가
		v.add("여진구");
		v.add("수지");
		v.addElement("설현");

		System.out.println("::::::::::::요소 추가후::::::::::::::");
		System.out.println("capacity : " + v.capacity()); // 
		System.out.println("size : " + v.size()); // 
	}
}
