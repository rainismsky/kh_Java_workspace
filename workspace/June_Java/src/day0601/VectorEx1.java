package day0601;

import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		System.out.println("::::::::Vector������:::::::");
		System.out.println("Capacity : " + v.capacity());
		System.out.println("size : " + v.size());
		
		v.add("������");
		v.add("����");
		v.addElement("����");
		
		System.out.println(":::::::::��� �߰���:::::::::::");
		System.out.println("capacity : " + v.capacity());
		System.out.println("size : " + v.size());
	}
}
