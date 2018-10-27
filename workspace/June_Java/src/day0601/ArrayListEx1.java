package day0601;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1,4));
		print(list1,list2);
		
		Collections.sort(list1);//list1�� list2�� �����Ѵ�
		Collections.sort(list2); //Collections.sort(List l)
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
		
		// 4,2,0,AA,B,C
		list2.add("B");
		list2.add("C");
		list2.add(3,"A"); //3�� �ε����� �߰��ǰ� �ڿ��ִ°��� �и� 
		print(list1,list2);
		
		list2.set(3, "AA"); //set�ϸ� AA�� �ٽ� ����
		print(list1,list2);
		
		// list1���� list2�� ��ġ�� �κи� ����� �������� �����Ѵ�.
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
		print(list1,list2);
		
		// list2���� list1�� ���Ե� ��ü���� �����Ѵ�.
		for(int i=list2.size()-1; i>=0; i--) {
			if(list1.contains(list2.get(i))) //�Ȱ��� ��ü�� �����ϱ����ؼ� contains�� �ִ��� Ȯ�� 
					//get(i) -> �ش� �ε����� ���� ... 
				list2.remove(i);
		}
		print(list1,list2);
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
		System.out.println();
	}
}
