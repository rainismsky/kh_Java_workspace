package testExercise;

public class BookTest {
	public static void main(String[] args) {
		Book bookArray[] = new Book[5];
		bookArray[0] = new Book("IT","SQL Plus",50000,5);
		bookArray[1] = new Book("IT","Java 2.0",40000,3);
		bookArray[2] = new Book("IT","JSP Servlet",60000,6);
		bookArray[3] = new Book("Nobel","davincicode",30000,10);
		bookArray[4] = new Book("Nobel","cloven hoof",50000,15);
		
		double sum=0;
		for(int i=0;i<bookArray.length;i++) {
			sum += bookArray[i].bookPrice;
			System.out.println(bookArray[i]);
	}System.out.println("책가격의 합 : " + sum + "원");
		
		
	}
}

class Book{

		String category;
		String bookName;
		double bookPrice;
		double bookDiscountRate;
		
		Book(){}
		
		Book(String category,String bookName, double bookPrice, double bookDiscountRate){
			this.category = category;
			this.bookName = bookName;
			this.bookPrice = bookPrice;
			this.bookDiscountRate = bookDiscountRate;
		}
		
		public void setCategory(String category) {
			this.category = category;
		}
		public String getCategory() {
			return category;
		}
		
		public void setBookName(String bookName) {
			this.bookName=bookName;
		}
		public String getBookName() {
			return bookName;
		}
		
		public void setBookPrice(double bookPrice) {
			this.bookPrice=bookPrice;
		}
		public double getBookPrice() {
			return bookPrice;
		}
		
		public void setBookDiscountRate(double bookDiscountRate) {
			this.bookDiscountRate =bookDiscountRate;
		}
		public double getBookDiscountRate() {
			return bookDiscountRate;
		}
		
		@Override
		public String toString() {
			return category + "\t" + bookName + "\t" +bookPrice + "원\t" + bookDiscountRate+"%";
		}
}