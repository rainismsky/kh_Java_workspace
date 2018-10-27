package day0601.collection;

public class Person2 {
	String name;
	int age;

	Person2(String name, int age) {
		System.out.println("생성자");
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Person2) {
			Person2 tmp = (Person2) obj;
			return name.equals(tmp.name) && age == tmp.age;
		}
		return false;
	}

	public int hashCode() {
		System.out.println("hashcode()실행");
		return name.hashCode() + age;
	}

	public String toString() {
		return name + ":" + age;
	}
}
