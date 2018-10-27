package day0517.oop;
public class Test {
	
	//String 데이터를 받아 출력하는 메소드 작성
	void printText(String text) {
		System.out.println(text);
	} 
	
	//int 데이터 하나를 받아 값을 하나 증가 시켜 리턴하는 메소드
	int increace(int i) {
		i++;
		return i;
	}
	
	//배열을 받아서 배열에 있는 모든 값의 합을 출력하는 메소드 작성
	int sum(int[] arr) {
		int sum = 0; //합계 저장
		for(int i: arr) {
			sum +=i;
		}
		System.out.println("합::"+sum);
		return sum;
	}
	
	//배열을 받아서 배열에 있는 모든 값중 제일 큰 값 출력하는 메소드 작성
	void max(int[] arr) {
		int max = 0; //최대값을 저장할수 있는 공간 생성
		for(int i : arr) {
			if(max > max) {
				max = i;
			}
		}
		System.out.println("최대값:"+max);
	}
	
	//배열을 받아서 배열에 있는 모든 값중 제일 작은 값 출력하는 메소드 작성
	void min(int[] arr) {
		int min = arr[0]; //최소값을 저장할수 있는 공간 생성
		for(int i : arr) {
			if(i < min) {
				min = i;
			}
		}
		System.out.println("최소값::"+min);
	}
	
	//배열을 받아서 배열에 있는 모든 값중 평균 출력
	void avg(int[] arr) {
		
	int total = sum(arr); //합계 저장
		double avg = (double)total / arr.length;
		System.out.println("평균값::"+avg);
	}	
		
	public static void main(String[] args) {
	Test t = new Test();
	int[] array = {12,41,36,56};
	//int[] array = {12,41,36,56}
	t.sum(array);
	t.max(array); 
	t.min(array);
	t.avg(array);
	
	}}
	
	
