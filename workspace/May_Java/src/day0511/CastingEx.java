package day0511;

public class castingEx {

		public static void main(String[] args) {
	
		/*int result = 2100000000 + 2100000000;
		System.out.println("21��+21�� = "+result);
		
		char c = 'A';
		System.out.println(c+1);//66 +�����Ͽ� c�� ĳ���õ�.
		
		byte b = 10;
		int i = b;
		System.out.println(b);
		System.out.println(i);
		
		int i1 = 300;
		byte b1 = (byte)i1;
		System.out.println(i1); //300
		System.out.println(b1); //44
		*/

	/*	int i = 300;
		double d = i; //i�� ���� �ִ� �� 300�� ����� ĳ�����ؼ� ������ ��Ų��.
		int i2 = (int)d;
		
		System.out.println(i);
		System.out.println(d);
	*/	
			
		/*double a,b,c;
		a = 44;
		b = 5;
		c = a/b;
		
		System.out.println(c); //8.8*/
	 		
	int a,b,c;
	a = 44;
	b = 5;
	c = a/b;
	
	double d = a / b;
	double d1 = (double) (a / b);
	double d2 = (double)  a / b;
	System.out.println(c); // 8
	System.out.println(d1);// 8.0
	System.out.println(d2);	//8.8
			
		}
}
