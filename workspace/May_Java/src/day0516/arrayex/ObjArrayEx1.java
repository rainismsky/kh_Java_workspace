package day0516.arrayex;

public class ObjArrayEx1 {
	public static void main(String args[]) {
		String[] arr;
		arr = new String[3];
		
		arr[0] ="Java ";
		arr[1] ="Array ";
		arr[2] = "Test ";
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(String s:arr) {
			System.out.println(s);
		}
		
		String[] arr1 = {"J", "A", "T"};
		String[] arr2 = new String[] {"J", "A", "T"};
		String[] arr3 = new String[] {new String("JJ"), new String("AA"),new String("TT")};
		
		for(int i=0;i<arr3.length;i++) {
			System.out.println(arr3[i]);
		}
	}
}
