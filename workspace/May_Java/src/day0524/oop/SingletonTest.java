package day0524.oop;
class Singleton{
	int x;
	
	static Singleton s = new Singleton();
	private Singleton(){}
	
	public static Singleton getInstance() {
		return s;
	}
	
	
}
public class SingletonTest {
	public static void main(String args[]) {
		//Singleton s1 = new Singleton(); 
		Singleton s1 = Singleton.getInstance();
		s1.x = 10;
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2.x); //10
	}
}
