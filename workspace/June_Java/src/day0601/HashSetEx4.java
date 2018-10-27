package day0601;

import java.util.HashSet;

public class HashSetEx4 {
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10)); //hashcode()
		System.out.println("d1추가----------");
		set.add(new Person2("David",10)); //hashcode(), equals()
		
		System.out.println(set);
	}
}

class Person2{
	String name;
	int age;
	
	Person2(String name, int age){
		System.out.println("생성자");
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		System.out.println("equals()실행");
		if(obj instanceof Person2){
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age ==tmp.age;
		}
		
		return false;
	}
	
	public int hashCode() {
		System.out.println(" hashCode()실행");
		return name.hashCode() + age;
	}
	
	public String toString() {
		return name + ":" + age;
	}
}
