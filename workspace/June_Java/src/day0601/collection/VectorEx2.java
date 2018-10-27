package day0601.collection;

import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args){
		Vector<Double> v = new Vector<Double>(2,5);
		
		//자원추가
		v.add(100.3); //0
		v.add(3.14); //1
		v.addElement(1000.); //2
		for(Double n : v)
			System.out.println(n); //추가된 요소들 출력
		
		//자원검색
		double search = 1000.0;	//검색할 요소 
		int index = v.indexOf(search);	//검색 /2 
		//indexOf:있는지 없는지 판단여부용으로도 많이 사용함.삭제할 요소가 Vector요소인지 검사.
		
		if(index != -1)
			System.out.println("검색요소" + search+"의 위치 :"+ index);
		else
			System.out.println("검색요소" + search + "가 읎다잉");
		
		System.out.println("::삭제 전 용량/크기 확인::");
		System.out.println("capacity : " + v.capacity()); //7
		System.out.println("size : " + v.size()); //3
		
		//자원삭제
		double del = 3.14; //삭제할 요소
		if(v.contains(del)) {	//삭제할 요소가 Vector의 요소인지 검사
			v.remove(del); //삭제
		}
	}
}

