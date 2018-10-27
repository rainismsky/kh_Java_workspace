package day0530;

public class ThrowEx2 {
	public void setData(String n)throws Exception{
		if(n.length()>=1) {
			String str = n.substring(0, 1); // 문자열에서 해당인덱스 앞까지 잘라냄 (0부터 1앞까지 -> 문자열 abc면 a)
			printData(str);
		}
	}
	
	private void printData(String n) throws NumberFormatException{
		int dan = Integer.parseInt(n);
		System.out.println(dan + "단" );
		System.out.println("------------");
		for(int i=0;i<9;i++)
			System.out.println(dan + "*" + (i+1) +"=" +(dan * (i+1)));
	}
	
	public static void main(String[] args) {
		ThrowEx2 t1 = new ThrowEx2();
		try {
			t1.setData(args[0]);
		}catch(Exception e) {
			System.out.println("첫 문자가 숫자가 아닙니다.");
			e.printStackTrace();
		}
	}
}
