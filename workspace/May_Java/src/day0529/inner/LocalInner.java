package day0529.inner;

public class LocalInner {

	int a =100;
	public void innerTest(int k) {
		int b = 200;
		final int c = k;
		class Inner{
			public void getData() {
				System.out.println("int a : " + a);
				System.out.println(b);
				System.out.println("final int c : " + c );
			}
		}
		Inner i = new Inner();
		i.getData();
	}
}
