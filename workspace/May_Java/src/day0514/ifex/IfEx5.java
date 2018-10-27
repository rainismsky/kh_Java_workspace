package day0514.ifex;

public class ifex5 {

	public static void main(String[] args) {
		int jumsu = Integer.parseInt(args[0]);
		String res;
		//if문안에 if문이 들어 올수 있음.
		
		if(jumsu >= 90 && jumsu <= 100) {
			res = "A+학점";			
		
			if(jumsu <= 98); //if안에 if를 넣을수 있다.(다중if)
				res="A학점";
		}else if (jumsu >= 90 && jumsu < 93) {
			res = "A-학점";
		}else if (jumsu >= 70 && jumsu < 80) {
			res = "B학점";
		}else if (jumsu >= 60 && jumsu < 70) {
			res = "C학점";
		}else if (jumsu >= 50 && jumsu < 60) {
			res = "D학점";
		}else res = "F학점이다.";
		
			System.out.println(res);
	}
	}
	
	
