package book;

class Book{
	String bookName;
	int bookPrice;
	double bookDiscount;
	
	Book(){}
	
	Book(String bookName, int bookPrice, double bookDiscount){
		setBookName(bookName);
		setBookPrice(bookPrice);
		setBookDiscount(bookDiscount);
		
		
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public double getBookDiscount() {
		return bookDiscount;
	}
	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}
	
	public double getDiscountBookPrice() { //인하된 책 가격을 리턴
		double discount = getBookPrice() - (getBookPrice()*getBookDiscount()/100);
		return discount;
		
	}
	
	@Override
	public String toString() {
		return bookName + "	" + bookPrice + "원	"+ bookDiscount + "%	" + getDiscountBookPrice() + "원";
	}
	
	
}
public class BookTest {
	public static void main(String args[]) {
		Book b = new Book("SQL Plus",50000,5.0);
		Book b2 = new Book("Java 2.0",40000,3.0);
		Book b3 = new Book("JSP Servlet", 60000, 6.0);
		
		System.out.println("책이름		가격	할인율	할인후금액");
		System.out.println("------------------------------------");
		System.out.println(b);
		System.out.println(b2);
		System.out.println(b3);
		
	}

}
