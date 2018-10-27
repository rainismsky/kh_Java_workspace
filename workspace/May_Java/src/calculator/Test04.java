package calculator;

public class Test04 {
	public static void main(String[] args) {
		calc cs = new calc();

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);

		int total = cs.calcSum(a, b, c, d);
		double avg = cs.calcAvg(total);
		char grade = cs.calcGrade(avg);
		
		cs.printClac(total, avg, grade);
	}
}

class calc {

	int calcSum(int a, int b, int c, int d) {
		int total = a + b + c + d;
		return total;
	}

	double calcAvg(int total) {
		double avg = (double) total / 4;
		return avg;
	}

	char calcGrade(double avg) {
		char grade;

		if (avg <= 100 && avg >= 90) {
			grade = 'A';
		} else if (avg < 90 && avg >= 70) {
			grade = 'B';
		} else if (avg < 70 && avg >= 50) {
			grade = 'C';
		} else if (avg < 50 && avg >= 30) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		return grade;
	}
	
	void printClac(int total,double avg, char grade) {
		System.out.println("Sum:" + total);
		System.out.println("Avg:" + avg);
		System.out.println(grade + "ÇÐÁ¡");
	}
}
