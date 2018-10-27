package day0514.ifex;

public class IfEx1 {
	public static void main(String[] args) {

		// if(조건식 /지정 및실행){조건식 결과가 true일때 실행할 문장}
		// }else {조건식 결과가 false일 때 실행할 문장}
		// 실행문이 1개일땐 {} 생략 가능
		// 인수,인자,parameter,argument :: 전달하는 값
		// 실행시 입력한 값을 전달 받아 사용.String데이터다.

		int su1 = Integer.parseInt(args[0]);
		String str = ""; // String은 항상 빈문자열("")로 초기화 시켜놓고 써야한다.

		if (su1 >= 50) {
			str = "50이상";
		} else {
			str = "50미만";

			/*
			 * false값일 경우 str 값을 받아올수가 없어 그래서 str엔 항상 빈문자열""으로 초기화 시켜놓고 써야 에러가 없어
			 */

		}
		System.out.println(str);

	}

}
