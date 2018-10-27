package day0525;

/*int A = 100; //인터페이스 안에선 키워드 굳이 안붙여도됨
  int getA();//밑에꺼가 상수가 된다*/

interface InterTest{
	static final int A = 100;
	abstract int getA();//abstract keyword는 생략 가능!
	}
class InterTestEx implements InterTest{
	public int getA() {
		return A;
	}

	public static void main(String[] args) {
	{
		InterTestEx it1 = InterTestEx();
		System.out.println("getA():"+it1.getA());
	}
	}

	private static InterTestEx InterTestEx() {
		// TODO Auto-generated method stub
		return null;
	}
	} 
	//객체는 항상 구현 클래스로 작성!!