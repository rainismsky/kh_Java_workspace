package day0601;

import java.util.Vector;

class A{}
class B extends A{}

public class Test {
	public static void main(String[] args) {
		Vector<A> v = new Vector<A>();
		v.add(new A());
		v.add(new B());
	}
}
