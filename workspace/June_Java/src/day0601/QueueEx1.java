package day0601;

import java.util.LinkedList;

public class QueueEx1 {
	public static void main(String[] args) {
		String[] item = {"�ҳ�Ÿ","������","���Ծ�"};
		LinkedList<String> q = new LinkedList<String>(); //StringŸ�Ը� �����ϴ� linkedList��ü�� ����
		
		for(String n : item) //item �迭���ִ� ���� �ϳ��� ����
			q.offer(n);// n�� ����
		System.out.println("q��ũ�� : " + q.size());
		
		
		String data = "";
		while((data = q.poll())!=null) //poll()�� ù��° ��Ҹ� ��ȯ �� ����
			System.out.println(data + "����!");
		System.out.println("q�� ũ�� �� " + q.size()); 
	}
}
