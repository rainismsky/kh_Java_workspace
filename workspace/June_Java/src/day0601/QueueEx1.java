package day0601;

import java.util.LinkedList;

public class QueueEx1 {
	public static void main(String[] args) {
		String[] item = {"소나타","렉스톤","제규어"};
		LinkedList<String> q = new LinkedList<String>(); //String타입만 저장하는 linkedList객체를 만듦
		
		for(String n : item) //item 배열에있는 것을 하나씩 꺼냄
			q.offer(n);// n에 저장
		System.out.println("q의크기 : " + q.size());
		
		
		String data = "";
		while((data = q.poll())!=null) //poll()은 첫번째 요소를 반환 후 삭제
			System.out.println(data + "삭제!");
		System.out.println("q의 크기 ㅣ " + q.size()); 
	}
}
