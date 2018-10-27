package day0518.oop;

class Pick{
	void maleRandom(String[] mname) {

		int[] num= {};
		int a=0;
		for(int i=0; i<mname.length; i++) {
			a = (int)Math.random()*5; 
				if(i%2==0) {
					System.out.println();
				}
				//a = num[i];
				System.out.print(mname[a] +" ");
				
			
		}
		
	/*	for(int i=0; i<mname.length; i++) {
			if(i%2==0) {
				System.out.println();
			}
			System.out.print(mname[i] +" ");
			
		}
		int[] num= {};
		for(int i=0;i<28;i++) {
			num[i] = (int)(Math.random()*28); 
		}
		for(int i=0;i<28;i++) {
			for()
			name[j];
		}
		*/
	}
}
public class Ex {
	
	public static void main(String[] args) {
		String[] male = {"aaa","bbb","ccc","ddd","eee"};
		String[] female = {"AAA","BBB","CCC","DDD","EEE"};
		
		Pick p = new Pick();
		p.maleRandom(male);
		
	}
	
}
