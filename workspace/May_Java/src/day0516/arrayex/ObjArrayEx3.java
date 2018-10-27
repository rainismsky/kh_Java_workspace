package day0516.arrayex;

public class ObjArrayEx3 {
	public static void main(String[] args) {
		int[][] test;
		test = new int[2][3];
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		
		test[1][0] = 500;
		test[1][1] = 600;
		test[1][2] = 700;
		
		for(int i=0; i<test.length; i++) //test.length=2
			for(int j=0; j<test[i].length; j++) { //test[i].length=3
				System.out.println("test["+i+"]["+j+"]="+test[i][j]);
			}
		
	}
}
