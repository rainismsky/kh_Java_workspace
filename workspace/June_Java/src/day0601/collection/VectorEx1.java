package day0601.collection;

import java.util.Vector;

class VectorEx1 {

	public static void main(String[] args) {

		Vector<String> v = new Vector<String>();

		System.out.println("::Vector������::");
		System.out.println("capacity : " + v.capacity()); // 
		System.out.println("size : " + v.size()); // 

		// �ڿ��߰�
		v.add("������");
		v.add("����");
		v.addElement("����");

		System.out.println("::::::::::::��� �߰���::::::::::::::");
		System.out.println("capacity : " + v.capacity()); // 
		System.out.println("size : " + v.size()); // 
	}
}
