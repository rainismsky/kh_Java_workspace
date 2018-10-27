package day0523.oop;

public class Ex {
	public static void main(String args[]) {
		B a = new B("jinju",25);
		System.out.println(a);
		
	}
}

class B{
	private String name;
	private int age;
	
	B(String name, int age){
		setName(name);
		setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age; 
	}

}
