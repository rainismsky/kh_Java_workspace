package day0530.oop;

class UserExceptionTest{
	public void test1(String[] n) throws UserException{
		System.out.println("Test1");
	if(n.length < 1)
		throw new UserException("�ϰ͵� ����"); //���� exception �߻�
	else
		throw new UserException("���� ����",703);// ���� exception �߻�

	}
	public static void main(String[] args) {
		UserExceptionTest ut = new UserExceptionTest();
		try {
			ut.test1(args);
		}catch(UserException ue) {
			//System.out.println(ue.getMessage());
			ue.printStackTrace();	
		}
}
}
