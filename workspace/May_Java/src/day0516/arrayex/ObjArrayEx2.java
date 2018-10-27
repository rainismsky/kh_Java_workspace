package day0516.arrayex;

public class ObjArrayEx2 {
	public static void main(String[] args) {
		//argument가 없으면 length가 0인 배열이 생성됨
		String[] arr;
		if(args.length > 0) {
			arr = args; //주소값을 넘겨줌 (똑같은 공간을 사용)
			for(int i=0; i<arr.length; i++) {
				System.out.println("arr[" + i + "] : " + arr[i]);
			}
		}else {
			System.out.println("args의 내용이 없습니다.");
		}
	}
}
