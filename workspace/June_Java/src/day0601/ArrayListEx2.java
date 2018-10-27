package day0601;
import java.util.*; 

public class ArrayListEx2 {
	public static void main(String[] args) { 
		final int LIMIT = 10;	// 자르고자 하는 글자의 개수를 지정한다.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ"; //길이43
		int length = source.length(); 
		

		List<String> list = new ArrayList<String>(length/LIMIT + 10); // 크기를 약간 여유 있게 잡는다.
												//43/10 은 4인데  여유롭게 10을 더해줘서 지정
		for(int i=0; i < length; i+=LIMIT) { 
			if(i+LIMIT < length ) //length보다 작으면 처리
				list.add(source.substring(i, i+LIMIT));  //ex_i가0일때) 0부터 10번인덱스까지 잘라서 list에 저장
			else 
				list.add(source.substring(i)); 
		} 

		for(int i=0; i < list.size(); i++) { 
			System.out.println(list.get(i)); 
		} 
	} // main()
}
//꺼내올때는 get으로 인덱스 지정해서 꺼내옴
//list에 더할때는 add나 addelement
