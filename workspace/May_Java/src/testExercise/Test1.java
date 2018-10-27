package testExercise;

public class Test1 {
	 public static void main(String args[]) {
    	 int [][]array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 
    	 double sum=0;
    	 double avg=0;
    	 int count=0;
    	 
    	 for(int i=0;i<=3;i++) {
    		 for(int j=0;j<=3;j++) {
    			 sum += array[i][j];
    			 count++;
    		 }
    	 }
    	 
    	 avg = sum/count;
    	 System.out.println("ÇÕ°è : " + sum);
    	 System.out.println("Æò±Õ : " + avg);
     }
}
