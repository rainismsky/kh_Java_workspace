package day0514.ifex;

public class ifex5 {

	public static void main(String[] args) {
		int jumsu = Integer.parseInt(args[0]);
		String res;
		//if���ȿ� if���� ��� �ü� ����.
		
		if(jumsu >= 90 && jumsu <= 100) {
			res = "A+����";			
		
			if(jumsu <= 98); //if�ȿ� if�� ������ �ִ�.(����if)
				res="A����";
		}else if (jumsu >= 90 && jumsu < 93) {
			res = "A-����";
		}else if (jumsu >= 70 && jumsu < 80) {
			res = "B����";
		}else if (jumsu >= 60 && jumsu < 70) {
			res = "C����";
		}else if (jumsu >= 50 && jumsu < 60) {
			res = "D����";
		}else res = "F�����̴�.";
		
			System.out.println(res);
	}
	}
	
	
