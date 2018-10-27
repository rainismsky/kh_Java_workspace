package day0515.forex;
public class ArrayEx1 {
public static void main(String[] args) {
		char[] ch; //배열 선언
		ch = new char[4]; //배열 생성 //캐릭터(char)만 4개 저장할수 있는 공간
		//배열은 한번 생성되는 순간 고정. (없는 인덱스 ,-인덱스 사용(x))
				
		// 배열 초기화
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';
		// ch[4] = 'a'; 이런 경우는 안된다고 하네요.(이유는 중복되는게 아니라 배열선언이 4개이기 때문임.)
		
		//배열 내용 출력 
		for(int i = 0 ; i < ch.length; i++) //저장되는 데이터 길이 (length)
			System.out.println("ch["+i+"]:"+ch[i]);
		
		int[] i = {1,2,3,4}; //i에는 배열의 주소값이 저장됨. (이렇게 제일 많이 만든다고 함.) 
		int[] i2 = new int[] {1,2,3,4};
		
		//foreach : 집합 데이터 안의 모든 데이터를 하나씩 순서대로 가져옴.
		//for(타입명변수: 집합데이터 ) {수행문}
		
		for(int iv : i) {
			System.out.println(iv);
		//더이상 가져올 데이터가 없을때까지 가져옴.
		}
						
	}

}
