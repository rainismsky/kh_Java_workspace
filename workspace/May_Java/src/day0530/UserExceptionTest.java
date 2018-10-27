package day0530;

public class UserExceptionTest {
	public void test1(String[] n) throws UserException{
		System.out.println("Test1");
		if(n.length <1)
			throw new UserException("아무것도 없음"); //강제 예외발생
		else
			throw new UserException("최종예선",703);//강제 예외발생
	}
	
	public static void main(String[] args) {
		UserExceptionTest ut = new UserExceptionTest();
		try {
			ut.test1(args);
		}catch(UserException ue) {
			ue.printStackTrace();                                                       
		}
	}
}
