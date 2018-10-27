package day0516;

public class ObjArrayEx2 {
public static void main(String[] args) {
	//argument(인수)가 없으면 length가 0인 배열생성 
	String[] arr;
	
	if(args.length > 0) { //args length(배열의길이는 4)
		arr = args; // args가 갖고 있는 값을 arr에게 주라는 명령
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"]:"+arr[i]);
		}
	}else {
		System.out.println("args의 내용이 없다.");
	}
}

}
