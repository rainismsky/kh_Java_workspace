package day0604.collection;

//Iterator = �÷��ǿ� ����� ��ü�� �о���� ����� ǥ��ȭ�� �������̽�. (��.ver)
//Enumeration (��.ver)
//�� �ΰ����� ��ü�� ����� �Ǹ� ��ü�� �̾ƿ;��ϸ� ���ݾ��̾ƿ��°� �ȵȴ�.

import java.util.*;
public class IteratorEx1 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,5);
		
		v.add("a");
		v.add("b");
		v.add("c");
		System.out.println("����ũ��: " + v.size());
		
		Iterator<String> it = v.iterator(); //Iterator���
		while(it.hasNext()) {
		System.out.println(it.next());
					
		//it.remove()l //���� �÷��ǿ� ��� ����
		}
		it.remove();
		System.out.println("���� ũ��:"+v.size());
		System.out.println(v);
	}
}
