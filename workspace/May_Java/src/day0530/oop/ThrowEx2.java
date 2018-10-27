package day0530.oop;

public class ThrowEx2 {
public void setData(String n)throws Exception{
	if(n.length() >=1) { //문자가 하나라도 있다면 이런일을 해라 라고 지정을 해줌 n
		String str = n.substring(0 , 1);
		printData(str);
	}}

private void printData(String n)throws NumberFormatException{
	int dan =Integer.parseInt(n);
	System.out.println(dan + "단"); System.out.println("----------");
	for (int i=0; i<9; i++)
		System.out.println(dan + "*" + (i+1) + "=" + (dan * (i +1)));
}
	
public static void main(String[] args) {
ThrowEx2 s1 = new ThrowEx2();
try {
	s1.setData(args[0]);
	}catch (Exception e){
		System.out.println("첫문자 숫자 아님");
		e.printStackTrace();
	
}}}

