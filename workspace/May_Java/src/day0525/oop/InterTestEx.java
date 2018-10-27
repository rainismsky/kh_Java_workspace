package day0525.oop;
interface InterTest{
	static final int A = 100; //키워드를 붙이지않아도 자동으로 상수로 취급
	abstract int getA(); //키워드를 붙이지않아도 자동으로 추상ㅁㅔ소드로 취급 ->인터페이스에선 키워드 안붙여도 상관없음
}
class InterTestEx implements InterTest{
	public int getA() {
		return A;
	}
	
	public static void main(String[] args) {
		InterTestEx it1 = new InterTestEx();
		System.out.println("getA():" + it1.getA());
	}
}
