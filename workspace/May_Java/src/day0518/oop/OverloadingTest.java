package day0518.oop;

class overloadingTest {
	public static void main(String[] args) {
		MyMath3 mm = new MyMath3();
		System.out.println("mm.add(3,3) 결과:" + mm.add(3, 3));
		System.out.println("mm.add(3L,3) 결과:" + mm.add(3L, 3));
		System.out.println("mm.add(3,3:) 결과:" + mm.add(3, 3L));
		System.out.println("mm.add(3L,3L) 결과:" + mm.add(3L, 3));

		int[] a = { 100, 200, 300 };
		System.out.println("mm.add(a) 결과:" + mm.add(a));
	}

}

class MyMath3 {
	int add(int a, int b) {
		System.out.println("int add(int a , int b)-");
		return a + b;
	}

	long add(int a, long b) {
		System.out.println("long add(int a , long b)-");
		return a + b;
	}

	long add(long a, int b) {
		System.out.println("long add(long a , int b)-");
		return a + b;
	}

	long add(long a, long b) {
		System.out.println("int add(long a , long b)-");
		return a + b;
	}

	int add(int[] a) { // 배열의 모든 요소의 합을 결과로 돌려줌
		System.out.println("int add(int[] a) -");
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i];

		}
		return result;
	}

}
