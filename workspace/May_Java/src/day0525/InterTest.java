package day0525;

/*int A = 100; //�������̽� �ȿ��� Ű���� ���� �Ⱥٿ�����
  int getA();//�ؿ����� ����� �ȴ�*/

interface InterTest{
	static final int A = 100;
	abstract int getA();//abstract keyword�� ���� ����!
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
	//��ü�� �׻� ���� Ŭ������ �ۼ�!!